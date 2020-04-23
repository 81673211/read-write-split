package com.fred.rwsplit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fred.rwsplit")
public class RwSplitApplication {

	public static void main(String[] args) {
		SpringApplication.run(RwSplitApplication.class, args);
	}

}
