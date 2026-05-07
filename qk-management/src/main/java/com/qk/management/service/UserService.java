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

    /**
     * 根据id查询用户信息
     * @param id
     * @return UserVO
     */
    UserVO getById(Integer id);

    /**
     * 查询所有用户信息
     * @return List<UserVO>
     */
    List<UserVO> selectAll();


    /**
     * 根据角色查询用户信息
     * @param roleLabel
     * @return List<UserVO>
     */
    List<UserVO> getByRole(String roleLabel);

    /**
     * 根据部门id查询用户信息
     * @param deptId
     * @return List<UserVO>
     */
    List<UserVO> getByDeptId(Integer deptId);
}
