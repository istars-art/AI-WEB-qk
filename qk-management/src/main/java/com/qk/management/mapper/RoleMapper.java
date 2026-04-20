package com.qk.management.mapper;

import com.qk.model.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 33465
 * @created 2026/4/19 下午8:45
 * @desciption  角色管理数据层接口
 */

@Mapper
public interface RoleMapper {
    /**
     * 根据交集条件查询角色列表
     * @param name 角色名称
     * @param label 角色标识
     * @return List<Role>
     */
    List<Role> selectByAndCondition(String name, String label);

    /**
     * 根据并集条件查询角色列表
     * @param name 角色名称
     * @param label 角色标识
     * @return List<Role>
     */
    List<Role> selectByOrCondition(String name, String label);

    /**
     * 根据并集条件查询角色列表，排除指定id的角色
     * @param id 角色id
     * @param name 角色名称
     * @param label 角色标识
     * @return List<Role>
     */
    List<Role> selectByOrConditionExcudeId(Integer id, String name, String label);

    /**
     * 根据id删除角色
     * @param id 角色id
     */
    void deleteById(Integer id);

    /**
     * 根据id查询角色
     * @param id 角色id
     * @return Role
     */
    Role selectById(Integer id);

    /**
     * 添加角色
     * @param role 角色信息
     */
    void insert(Role role);

    /**
     * 修改角色
     * @param role 角色信息
     */
    void updateById(Role role);

    /**
     * 查询所有角色
     * @return List<Role>
     */
    List<Role> selectAll();
}
