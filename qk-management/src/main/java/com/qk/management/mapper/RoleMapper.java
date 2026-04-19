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
     * 根据条件查询角色列表
     * @param name 角色名称
     * @param label 角色标识
     * @return List<Role>
     */
    List<Role> selectByCondition(String name, String label);
}
