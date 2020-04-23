package com.fred.rwsplit;

import com.fred.rwsplit.domain.Stu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RWMapper {

    Stu get(int id);

    void insert(@Param("stu") Stu stu);
}
