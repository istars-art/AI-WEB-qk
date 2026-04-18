package com.qk.management.controller;

import com.qk.common.PageResult;
import com.qk.common.Result;
import com.qk.management.service.DeptService;
import com.qk.model.dto.DeptSaveDTO;
import com.qk.model.vo.DeptVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author 33465
 * @created 2026/4/18 上午11:26
 * @desciption 部门管理控制器
 */

@RestController
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping
    public Result save(@RequestBody @Validated DeptSaveDTO dto) {

        deptService.save(dto);

        return Result.success();
    }

    @GetMapping
    public Result page(
            String name,
            Integer status,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize
    ){

        PageResult<DeptVO> result = deptService.page(name, status, page, pageSize);

        return Result.success(result);
    }


}




















