package com.qk.management.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.qk.management.mapper.DeptMapper;
import com.qk.management.service.DeptService;
import com.qk.model.dto.DeptSaveDTO;
import com.qk.model.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author 33465
 * @created 2026/4/18 下午12:10
 * @desciption 部门管理业务服务实体类
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptMapper deptMapper;

    @Override
    public void save(DeptSaveDTO dto) {
        //将dto转换成Dept实体类
        Dept dept = BeanUtil.copyProperties(dto, Dept.class);
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        //TODO:保存部门信息
        deptMapper.insert(dept);

    }
}
   