

package com.qk.management.aop.service;

import com.qk.management.aop.anno.Remark;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by MrZhao on 2026/4/28
 */
@Service
public class EmployeeService {


    @Remark
    public void addEmployee() throws InterruptedException {

        TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        System.out.println("添加员工");

    }

    public void updateEmployee() throws InterruptedException {

        TimeUnit.SECONDS.sleep(new Random().nextInt(20));
        System.out.println("修改员工");

    }

    public void deleteEmployee() throws InterruptedException {

        TimeUnit.SECONDS.sleep(new Random().nextInt(3));
        System.out.println("删除员工");

    }

    public void queryEmployee(){
        System.out.println("查询员工");
    }



}
