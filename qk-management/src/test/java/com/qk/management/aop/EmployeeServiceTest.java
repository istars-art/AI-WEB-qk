package com.qk.management.aop;

import com.qk.management.aop.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 33465
 * @created 2026/4/28 下午6:46
 * @desciption
 */
@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    EmployeeService employeeService;

    @Test
    public void testAddEmployee() throws InterruptedException {
        employeeService.addEmployee();
    }
}
   