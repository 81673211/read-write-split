package com.fred.rwsplit;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class DataSourceAop {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceAop.class);

    @Pointcut("(execution(* com.fred.rwsplit.RWService.select*(..)) " +
            "|| execution(* com.fred.rwsplit.RWService.find*(..)) " +
            "|| execution(* com.fred.rwsplit.RWService.get*(..)))")
    public void readPointcut() {
        LOGGER.info("read only operate ,into slave db");
    }

    @Pointcut("execution(* com.fred.rwsplit.RWService.insert*(..)) " +
            "|| execution(* com.fred.rwsplit.RWService.update*(..)) " +
            "|| execution(* com.fred.rwsplit.RWService.delete*(..)) ")
    public void writePointcut() {
        LOGGER.info("read or write operate ,into master db");
    }

    @Before("readPointcut()")
    public void read() {
        LOGGER.info("read operate");
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {
        LOGGER.info("write operate");
        DBContextHolder.master();
    }
}
