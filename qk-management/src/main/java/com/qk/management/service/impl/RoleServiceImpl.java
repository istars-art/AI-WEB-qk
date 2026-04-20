package com.qk.management.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qk.common.PageResult;
import com.qk.common.enums.QkBizExceptionInfoEnum;
import com.qk.common.exception.QkBizException;
import com.qk.management.mapper.RoleMapper;
import com.qk.management.service.RoleService;
import com.qk.model.dto.RolePage;
import com.qk.model.dto.RoleSaveDTO;
import com.qk.model.dto.RoleUpdateDTO;
import com.qk.model.entity.Role;
import com.qk.model.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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
        List<Role> roleList = roleMapper.selectByAndCondition(dto.getName(), dto.getLabel());

        PageInfo<Role> pageInfo = PageInfo.of(roleList);

        List<RoleVO> voList = roleList.stream()
                .map(role -> BeanUtil.copyProperties(role, RoleVO.class))
                .toList();

        return PageResult.<RoleVO>builder()
                .total(pageInfo.getTotal())
                .rows(voList)
                .build();
    }

    @Override
    public void deleteById(Integer id) {
        // 检验id是否存在、是否为null
        Role role = roleMapper.selectById(id);
        if (Objects.isNull(role)){
            throw new QkBizException(QkBizExceptionInfoEnum.ROLE_NOT_EXIST);
        }
        roleMapper.deleteById(id);
    }

    @Override
    public void save(RoleSaveDTO dto) {
        // 检验角色名称、角色标识是否重复
        List<Role> roleList = roleMapper.selectByOrCondition(dto.getName(), dto.getLabel());
        if (!roleList.isEmpty()){
            throw new QkBizException(QkBizExceptionInfoEnum.ROLE_REPEAT);
        }

        // 封装添加数据
        Role role = BeanUtil.copyProperties(dto, Role.class);
        role.setCreateTime(LocalDateTime.now());
        role.setUpdateTime(LocalDateTime.now());
        roleMapper.insert(role);
    }

    @Override
    public RoleVO getById(Integer id) {
        Role role = roleMapper.selectById(id);
        if (Objects.isNull(role)){
            throw new QkBizException(QkBizExceptionInfoEnum.ROLE_NOT_EXIST);
        }
        return BeanUtil.copyProperties(role, RoleVO.class);
    }

    @Override
    public void update(RoleUpdateDTO dto) {
        // 检查id是否存在、是否为null(TODO 防前端)
        if (Objects.isNull(roleMapper.selectById(dto.getId()))){
            throw new QkBizException(QkBizExceptionInfoEnum.ROLE_NOT_EXIST);
        }
        // 检查除dto.id外，角色名称、角色标识是否重复
        List<Role> roleList = roleMapper.selectByOrConditionExcudeId(dto.getId(), dto.getName(), dto.getLabel());
        if (!roleList.isEmpty()){
            throw new QkBizException(QkBizExceptionInfoEnum.ROLE_REPEAT);
        }

        //TODO 执行更新操作
        Role role = BeanUtil.copyProperties(dto, Role.class);
        role.setUpdateTime(LocalDateTime.now());
        roleMapper.updateById(role);
    }

    @Override
    public List<RoleVO> getAll() {
       List<Role> roleList = roleMapper.selectAll();

       return roleList.stream()
                .map(role -> BeanUtil.copyProperties(role, RoleVO.class))
                .toList();
    }
}
