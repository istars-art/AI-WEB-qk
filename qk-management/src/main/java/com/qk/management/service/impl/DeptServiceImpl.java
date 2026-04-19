package com.qk.management.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qk.common.PageResult;
import com.qk.common.enums.QkBizExceptionInfoEnum;
import com.qk.common.enums.StatusEnum;
import com.qk.common.exception.QkBizException;
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
import java.util.Objects;

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
        //名称重复检验
        List<Dept> depts = deptMapper.selectByName(dto.getName());
        if (!depts.isEmpty()){
            throw new QkBizException(QkBizExceptionInfoEnum.DEPT_NAME_REPEAT);
        }
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
    public DeptVO getById(Integer id) {
        //id校验
        Dept dept = deptMapper.selectById(id);
        if (Objects.isNull(dept)){
            throw new QkBizException(QkBizExceptionInfoEnum.DEPT_NOT_EXIST);
        }
        return BeanUtil.copyProperties(dept, DeptVO.class);
    }


    @Override
    public void update(DeptUpdateDTO dto) {
        //id校验
        if (Objects.isNull(deptMapper.selectById(dto.getId()))){
            throw new QkBizException(QkBizExceptionInfoEnum.DEPT_NOT_EXIST);
        }
        // 名称重复检验
        List<Dept> depts = deptMapper.selectByIdAndName(dto.getId(), dto.getName());
        if (!depts.isEmpty()){
            throw new QkBizException(QkBizExceptionInfoEnum.DEPT_NAME_REPEAT);
        }

        Dept dept = BeanUtil.copyProperties(dto, Dept.class);
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }

    @Override
    public void delete(Integer id) {
        Dept dept = deptMapper.selectById(id);
        if (Objects.isNull(dept)){
            throw new QkBizException(QkBizExceptionInfoEnum.DEPT_NOT_EXIST);
        }
        if (Objects.equals(dept.getStatus(), StatusEnum.ENABLE.getValue())){
            throw new QkBizException(QkBizExceptionInfoEnum.DEPT_STATUS_INVALID);
        }
        deptMapper.delete(id);
    }

    @Override
    public List<DeptVO> requestAll() {

        List<Dept> deptList = deptMapper.selectAll();
        return deptList.stream()
                .map(dept -> BeanUtil.copyProperties(dept, DeptVO.class))
                .toList();
    }

}
   