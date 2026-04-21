package com.qk.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * @author 33465
 * @created 2026/4/21 下午9:14
 * @desciption 用户保存数据封装实体类
 */
@Data
public class UserSaveDTO {
    /**
     * 用户名，唯一
     */
    @NotBlank(message = "用户名不能为空")
    @Size(min = 2, max = 20, message = "用户名长度必须在2到20之间")
    private String username;

    /**
     * 姓名
     */
    @NotBlank(message = "姓名不能为空")
    @Size(min = 2, max = 20, message = "姓名长度必须在2到20之间")
    private String name;

    /**
     * 手机号，唯一
     */
    @NotBlank(message = "手机号不能为空")
    @Size(min = 11, max = 11, message = "手机号长度必须为11位")
    @Pattern(regexp = "^1[3-9]\\d{8}$", message = "手机号格式不正确")
    private String phone;

    /**
     * 邮箱，唯一
     */
    @NotBlank(message = "邮箱不能为空")
    @Size(min = 5, max = 50, message = "邮箱长度必须在5到50之间")
    @Pattern(regexp = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", message = "邮箱格式不正确")
    private String email;

    /**
     * 性别，1: 男，2: 女
     */
    @NotNull(message = "性别不能为空")
    private Integer gender;

    /**
     * 状态，1: 正常，0: 停用
     */
    @NotNull(message = "状态不能为空")
    private Integer status;

    /**
     * 部门id，关联部门表主键
     */
    private Integer deptId;

    /**
     * 角色id，关联角色表主键
     */
    private Integer roleId;

    /**
     * 头像url
     */
    private String image;

    /**
     * 备注，50字以内
     */
    @Size(max = 50, message = "备注长度不能超过50字")
    private String remark;
}
   