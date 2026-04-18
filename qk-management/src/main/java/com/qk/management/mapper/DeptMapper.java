package com.qk.management.mapper;

import com.qk.model.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 33465
 * @created 2026/4/18 上午11:29
 * @desciption 部门管理数据层接口
 */

@Mapper
public interface DeptMapper {
    /**
     * 部门添加
     * @param dept 部门实体类
     */
    void insert(Dept dept);

    /**
     * 根据条件查询部门列表
     * @param name 部门名称
     * @param status 部门状态
     * @return List<Dept>
     */
    List<Dept> selectByCondition(String name, Integer status);

    /**
     * 根据id查询部门
     * @param id 部门id
     * @return Dept
     */
    Dept selectById(Integer id);

    /**
     * 部门修改
     * @param dept 部门修改数据封装对象dto
     */
    void update(Dept dept);

    /**
     * 根据id删除部门
     * @param id 部门id
     */
    void delete(Integer id);

    /**
     * 查询所有部门
     * @return List<Dept>
     */
    List<Dept> selectAll();
}
