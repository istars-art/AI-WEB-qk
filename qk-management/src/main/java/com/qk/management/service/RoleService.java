package com.qk.management.service;

import com.qk.common.PageResult;
import com.qk.model.dto.RolePage;
import com.qk.model.vo.RoleVO;

/**
 * @author 33465
 * @created 2026/4/19 下午8:43
 * @desciption 角色管理业务服务接口
 */

public interface RoleService {
    /**
     * 角色列表分页查询
     * @param dto 分页参数
     * @return PageResult<RoleVO>
     */
    PageResult<RoleVO> getByPage(RolePage dto);
}
