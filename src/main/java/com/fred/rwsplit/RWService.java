package com.fred.rwsplit;

import com.fred.rwsplit.domain.Stu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RWService {

    @Autowired
    private RWMapper rwMapper;

    public Stu get(int id) {
        return rwMapper.get(id);
    }

    public void insert(String name) {
        final Stu stu = new Stu();
        stu.setName(name);
        rwMapper.insert(stu);
    }
}
