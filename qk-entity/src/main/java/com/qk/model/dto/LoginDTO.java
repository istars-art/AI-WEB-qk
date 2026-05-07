package com.qk.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author 33465
 * @created 2026/5/7 下午8:23
 * @desciption
 */
@Data
public class LoginDTO {
    @NotBlank(message = "用户名不能为空！")
    private String username;
    @NotBlank(message = "密码不能为空！")
    private String password;
}
   