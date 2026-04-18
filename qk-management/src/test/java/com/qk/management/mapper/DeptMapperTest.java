package com.qk.management.mapper;

import com.qk.model.entity.Dept;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class DeptMapperTest {

    @Autowired
    DeptMapper deptMapper;

    @Test
    void insert() {
        Dept dept = new Dept();
        dept.setName("测试部门");
        dept.setStatus(1);
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }
}