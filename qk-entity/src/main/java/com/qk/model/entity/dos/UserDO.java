package com.qk.model.entity.dos;

import lombok.Data;

import java.time.LocalDateTime;

/**
 *
 * @author MrZhao
 * @created 2026-04-19 18:29
 * @description 用户数据对象
 *
 *  sql 语句 多表查询语句 多表 结果放到任何一个实体类都不能完全封装此时需要创建一个DO！
 *
 */
@Data
public class UserDO {

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
