package com.qk.management.controller;

import cn.hutool.json.JSONUtil;
import com.qk.common.PageResult;
import com.qk.common.Result;
import com.qk.management.service.DeptService;
import com.qk.model.dto.DeptSaveDTO;
import com.qk.model.dto.DeptUpdateDTO;
import com.qk.model.vo.DeptVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 33465
 * @created 2026/4/18 上午11:26
 * @desciption 部门管理控制器
 */

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping
    public Result save(@RequestBody @Validated DeptSaveDTO dto) {
        log.info("保存的部门信息是:{}", JSONUtil.parse(dto));

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

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        DeptVO deptVO = deptService.getById(id);
        return Result.success(deptVO);
    }

    @PutMapping
    public Result update(@RequestBody @Validated DeptUpdateDTO dto){
        log.info("修改的部门信息是:{}", JSONUtil.parse(dto));
        deptService.update(dto);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除的部门id是:{}",id);
        deptService.delete(id);
        return Result.success();
    }

    @GetMapping("/list")
    public Result requestAll(){
        List<DeptVO> result = deptService.requestAll();
        return Result.success(result);
    }

}




















