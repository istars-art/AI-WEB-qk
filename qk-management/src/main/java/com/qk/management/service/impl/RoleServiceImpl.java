package com.qk.management.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qk.common.PageResult;
import com.qk.management.mapper.RoleMapper;
import com.qk.management.service.RoleService;
import com.qk.model.dto.RolePage;
import com.qk.model.entity.Role;
import com.qk.model.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 33465
 * @created 2026/4/19 下午8:44
 * @desciption 角色管理业务服务实体类
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public PageResult<RoleVO> getByPage(RolePage dto) {
        PageHelper.startPage(dto.getPage(), dto.getPageSize());
        List<Role> roleList = roleMapper.selectByCondition(dto.getName(), dto.getLabel());

        PageInfo<Role> pageInfo = PageInfo.of(roleList);

        List<RoleVO> voList = roleList.stream()
                .map(role -> BeanUtil.copyProperties(role, RoleVO.class))
                .toList();

        return PageResult.<RoleVO>builder()
                .total(pageInfo.getTotal())
                .rows(voList)
                .build();
    }
}
   