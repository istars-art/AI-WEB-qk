package com.qk.management.controller;

import com.qk.common.Result;
import com.qk.management.service.DeptService;
import com.qk.model.dto.DeptSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 33465
 * @created 2026/4/18 上午11:26
 * @desciption 部门管理控制器
 */

@RestController
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    DeptService deptService;

    /**
     * 部门添加
     * @param dto 部门添加数据封装对象dto
     * @return Result 统一返回结果
     */
    @PostMapping
    public Result save(@RequestBody @Validated DeptSaveDTO dto) {

        deptService.save(dto);

        return Result.success();
    }
}
   