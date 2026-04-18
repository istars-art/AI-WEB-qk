package com.qk.management.mapper;

import com.qk.model.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 33465
 * @created 2026/4/18 上午11:29
 * @desciption 部门管理数据层接口
 */

@Mapper
public interface DeptMapper {
    void insert(Dept dept);
}
