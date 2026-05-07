package com.qk.management.service.impl;

import com.qk.common.enums.QkBizExceptionInfoEnum;
import com.qk.common.exception.QkBizException;
import com.qk.management.mapper.RoleMapper;
import com.qk.management.mapper.UserMapper;
import com.qk.management.service.LoginService;
import com.qk.model.dto.LoginDTO;
import com.qk.model.entity.Role;
import com.qk.model.entity.User;
import com.qk.model.vo.LoginVO;
import com.qk.model.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;

/**
 * @author 33465
 * @created 2026/5/7 下午8:31
 * @desciption
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public LoginVO login(LoginDTO loginDTO) {
        // 1. 对密码进行散列处理
        String encodePassword = DigestUtils.md5DigestAsHex(loginDTO.getPassword().getBytes());

        User user = userMapper.selectByUsernameAndPassword(loginDTO.getUsername(), encodePassword);
        // 2. 校验 用户
        if (ObjectUtils.isEmpty(user)){
            throw new QkBizException(QkBizExceptionInfoEnum.LOGIN_ACCOUNT_OR_PASSWORD_ERROR);
        }

        // 3. 获取用户角色
        Role role = roleMapper.selectById(user.getRoleId());

        // 4. 封装返回
        return LoginVO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .name(user.getName())
                .image(user.getImage())
                .roleLabel(role.getLabel())
//                .token() // TODO: 2026/5/7 生成token
                .build();
    }
}
   