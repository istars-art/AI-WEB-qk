package com.qk.management.controller;

import cn.hutool.json.JSONUtil;
import com.qk.common.PageResult;
import com.qk.common.Result;
import com.qk.management.service.UserService;
import com.qk.model.dto.UserPage;
import com.qk.model.dto.UserSaveDTO;
import com.qk.model.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 33465
 * @created 2026/4/21 下午8:25
 * @desciption 用户管理控制器
 */
@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public Result Page(UserPage pageDTO){
        PageResult<UserVO> result = userService.page(pageDTO);
        return Result.success(result);
    }

    @PostMapping
    public Result save(@RequestBody UserSaveDTO dto){
        log.info("保存的用户信息为:{}", JSONUtil.parse(dto));
        userService.save(dto);
        return Result.success();
    }

    @DeleteMapping("/{ids}")
    public Result deleteByIds(@PathVariable List<Integer> ids){
        log.info("删除的用户id有:{}",ids);
        userService.deleteByIds(ids);
        return Result.success();
    }


}
   