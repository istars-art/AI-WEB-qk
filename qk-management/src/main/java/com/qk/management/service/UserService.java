package com.qk.management.service;

import com.qk.common.PageResult;
import com.qk.model.dto.UserPage;
import com.qk.model.dto.UserSaveDTO;
import com.qk.model.vo.UserVO;

import java.util.List;

/**
 * @author 33465
 * @created 2026/4/21 下午8:27
 * @desciption 用户管理服务接口
 */

public interface UserService {
    /**
     * 分页查询用户信息
     * @param pageDTO
     * @return PageResult<UserVO>
     */
    PageResult<UserVO> page(UserPage pageDTO);

    /**
     * 保存用户信息
     * @param dto
     */
    void save(UserSaveDTO dto);

    /**
     * 删除用户信息
     * @param ids
     */
    void deleteByIds(List<Integer> ids);
}
