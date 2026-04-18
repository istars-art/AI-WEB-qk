package com.qk.management.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qk.common.PageResult;
import com.qk.management.mapper.DeptMapper;
import com.qk.management.service.DeptService;
import com.qk.model.dto.DeptSaveDTO;
import com.qk.model.dto.DeptUpdateDTO;
import com.qk.model.entity.Dept;
import com.qk.model.vo.DeptVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

    @Override
    public PageResult<DeptVO> page(String name, Integer status, Integer page, Integer pageSize) {
        //基于PageHelper分页插件实现分页
        PageHelper.startPage(page, pageSize);
        List<Dept> deptList = deptMapper.selectByCondition(name, status);
        // 将deptList 转成PageHelper 的对象PageInfo
        PageInfo<Dept> pageInfo = PageInfo.of(deptList);
        List<DeptVO> voList = deptList.stream()
                .map(dept -> BeanUtil.copyProperties(dept, DeptVO.class))
                .toList();
        return PageResult.<DeptVO>builder()
                .total(pageInfo.getTotal())
                .rows(voList)
                .build();
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.selectById(id);
    }

    @Override
    public void update(DeptUpdateDTO dto) {
        Dept dept = BeanUtil.copyProperties(dto, Dept.class);
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}
   