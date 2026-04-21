package com.qk.model.vo;

import java.time.LocalDateTime;

/**
 * @author 33465
 * @created 2026/4/21 下午8:38
 * @desciption 用户信息返回实体类
 */
public class UserVO {
    /**
     * id, 主键
     */
    private Integer id;
    /**
     * 姓名
     */
    private String name;

    /**
     * 用户名，唯一
     */
    private String username;
    /**
     * 头像url
     */
    private String image;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 手机号，唯一
     */
    private String phone;

    /**
     * 状态，1: 正常，0: 停用
     */
    private Integer status;
    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
}
   