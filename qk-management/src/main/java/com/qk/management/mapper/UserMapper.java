package com.qk.management.mapper;

import com.qk.model.dto.UserPage;
import com.qk.model.entity.User;
import com.qk.model.entity.dos.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 33465
 * @created 2026/4/21 下午8:29
 * @desciption 用户数据访问接口
 */

@Mapper
public interface UserMapper {
    /**
     * 根据条件查询用户信息
     * @param pageDTO
     * @return
     */
    List<UserDO> selectByCondition(UserPage pageDTO);

    /**
     * 根据用户名或手机号或邮箱查询用户信息
     * @param username
     * @param phone
     * @param email
     * @return
     */
    User selectByUsernameOrPhoneOrEmailLimitOne(String username, String phone, String email);

    /**
     * 保存用户信息
     * @param user
     */
    void insert(User user);

    /**
     * 根据id列表删除用户信息
     * @param ids
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 根据id列表查询用户信息
     * @param ids
     * @return
     */
    List<User> selectByIds(List<Integer> ids);

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User selectById(Integer id);

    /**
     * 查询所有用户信息
     * @return
     */
    @Select("select * from user")
    List<User> selectAll();

    /**
     * 根据角色查询用户信息
     * @param roleLabel
     * @return
     */
    List<User> selectByRoleLabel(String roleLabel);

    /**
     * 根据部门id查询用户信息
     * @param deptId
     * @return
     */
    List<User> selectByDeptId(Integer deptId);

    /**
     * 根据用户名和密码查询用户信息
     * @param username 用户名
     * @param password 密码
     * @return 用户信息
     */
    @Select("select * from user where username = #{username} and password = #{password}")
    User selectByUsernameAndPassword(String username, String password);
}
