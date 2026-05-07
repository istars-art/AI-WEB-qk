package com.qk.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 33465
 * @created 2026/5/7 下午8:26
 * @desciption
 * <p>
 *     封装登录接口响应数据
 * </p>
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginVO {
    private Integer id;
    private String username;
    private String name;
    private String image;
    private String roleLabel;
    private String token;
}
   