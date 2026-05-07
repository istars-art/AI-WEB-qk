package com.qk.management.controller;

import com.qk.common.Result;
import com.qk.management.service.LoginService;
import com.qk.model.dto.LoginDTO;
import com.qk.model.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 33465
 * @created 2026/5/7 下午8:24
 * @desciption
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping
    public Result login(@RequestBody LoginDTO loginDTO){
        LoginVO loginVO = loginService.login(loginDTO);
        return Result.success(loginVO);
    }
}
   