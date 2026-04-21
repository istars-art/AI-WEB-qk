package com.qk.model.dto;

import lombok.Data;

/**
 * @author 33465
 * @created 2026/4/21 下午8:34
 * @desciption 用户分页查询参数
 */
@Data
public class UserPage extends PageBaseDTO{
    private String name;
    private Integer status;
    private String phone;
    private Integer deptId;
}
   