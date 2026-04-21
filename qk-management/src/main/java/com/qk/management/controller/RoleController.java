package com.qk.management.controller;

import cn.hutool.json.JSONUtil;
import com.qk.common.PageResult;
import com.qk.common.Result;
import com.qk.management.service.RoleService;
import com.qk.model.dto.RolePage;
import com.qk.model.dto.RoleSaveDTO;
import com.qk.model.dto.RoleUpdateDTO;
import com.qk.model.vo.RoleVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 33465
 * @created 2026/4/19 下午8:42
 * @desciption 角色管理控制器
 */
@Slf4j
@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public Result getByPage(RolePage dto) {
        PageResult<RoleVO> result = roleService.getByPage(dto);

        return Result.success(result);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id) {
        log.info("删除的角色id是:{}", id);
        roleService.deleteById(id);

        return Result.success();
    }

    @PostMapping
    public Result save(@RequestBody RoleSaveDTO dto) {
        log.info("保存的角色信息是:{}", JSONUtil.parse(dto));
        roleService.save(dto);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        RoleVO roleVO = roleService.getById(id);
        return Result.success(roleVO);
    }

    @PutMapping
    public Result update(@RequestBody RoleUpdateDTO dto) {
        log.info("修改的角色信息是:{}", JSONUtil.parse(dto));
        roleService.update(dto);
        return Result.success();
    }

    @GetMapping("/list")
    public Result getAll() {
        List<RoleVO> list = roleService.getAll();
        return Result.success(list);
    }
}
   