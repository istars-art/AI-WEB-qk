package com.qk.management.controller;

import com.qk.common.PageResult;
import com.qk.common.Result;
import com.qk.management.service.RoleService;
import com.qk.model.dto.RolePage;
import com.qk.model.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 33465
 * @created 2026/4/19 下午8:42
 * @desciption 角色管理控制器
 */
@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public Result getByPage(RolePage dto){
        PageResult<RoleVO> result = roleService.getByPage(dto);

        return Result.success(result);
    }
}
   