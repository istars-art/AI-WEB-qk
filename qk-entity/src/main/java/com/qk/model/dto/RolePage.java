package com.qk.model.dto;

import lombok.Data;

/**
 * @author 33465
 * @created 2026/4/19 下午9:02
 * @desciption 角色分页查询DTO
 */
@Data
public class RolePage extends PageBaseDTO{
    private String name;
    private String label;
}
   