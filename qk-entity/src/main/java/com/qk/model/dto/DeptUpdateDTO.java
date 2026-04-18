package com.qk.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 33465
 * @created 2026/4/18 下午8:47
 * @desciption 修改部门信息数据封装实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeptUpdateDTO {
    /**
     * 部门id
     */
    @NotBlank(message = "部门id不能为空")
    private Integer id;
    /**
     * 部门名称
     */
    @NotBlank(message = "部门名称不能为空")
    private String name;
}
   