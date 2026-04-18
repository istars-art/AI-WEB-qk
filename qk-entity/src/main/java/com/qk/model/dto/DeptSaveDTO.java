package com.qk.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 33465
 * @created 2026/4/18 下午12:05
 * @desciption 部门添加数据封装对象dto
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unused")
public class DeptSaveDTO {

    /**
     * 部门名称
     */
    @NotBlank(message = "部门名称不能为空")
    String name;

    /**
     * 部门状态
     */
    @NotBlank(message = "部门状态不能为空")
    Integer status;
}
   