package com.qk.management.service;

import com.qk.common.PageResult;
import com.qk.model.dto.DeptSaveDTO;
import com.qk.model.dto.DeptUpdateDTO;
import com.qk.model.entity.Dept;
import com.qk.model.vo.DeptVO;

/**
 * @author 33465
 * @created 2026/4/18 上午11:30
 * @desciption 部门管理业务服务接口
 */

public interface DeptService {
    /**
     * 部门添加
     * @param dto 部门添加数据封装对象dto
     */
    void save(DeptSaveDTO dto);

    /**
     * 分页条件查询部门列表
     * @param name 部门名称
     * @param status 部门状态
     * @param page 页码
     * @param pageSize 页大小
     * @return PageResult 部门列表VO对象
     */
    PageResult<DeptVO> page(String name, Integer status, Integer page, Integer pageSize);

    /**
     * 根据id查询部门
     * @param id 部门id
     * @return Dept 部门实体类
     */
    Dept getById(Integer id);

    /**
     * 部门修改
     * @param dto 部门修改数据封装对象dto
     */
    void update(DeptUpdateDTO dto);
}
