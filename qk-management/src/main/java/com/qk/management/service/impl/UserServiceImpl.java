package com.qk.management.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.DesensitizedUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qk.common.PageResult;
import com.qk.common.enums.QkBizExceptionInfoEnum;
import com.qk.common.exception.QkBizException;
import com.qk.management.mapper.UserMapper;
import com.qk.management.service.UserService;
import com.qk.model.dto.UserPage;
import com.qk.model.dto.UserSaveDTO;
import com.qk.model.entity.User;
import com.qk.model.entity.dos.UserDO;
import com.qk.model.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * @author 33465
 * @created 2026/4/21 下午8:28
 * @desciption  用户管理服务实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageResult<UserVO> page(UserPage pageDTO) {
        PageHelper.startPage(pageDTO.getPage(), pageDTO.getPageSize());
        List<UserDO> list = userMapper.selectByCondition(pageDTO);
        PageInfo<UserDO> pageInfo = new PageInfo<>(list);

        List<UserVO> userVOs = list.stream()
                .map(dos -> {
                            dos.setPhone(DesensitizedUtil.mobilePhone(dos.getPhone()));
                            return BeanUtil.copyProperties(dos, UserVO.class);
                        }
                )
                .toList();

        return PageResult.<UserVO>builder()
                .total(pageInfo.getTotal())
                .rows(userVOs)
                .build();
    }

    @Override
    public void save(UserSaveDTO dto) {
        User user =  userMapper.selectByUsernameOrPhoneOrEmailLimitOne(dto.getUsername(), dto.getPhone(), dto.getEmail());
        // 检验用户名、手机号、邮箱是否重复
        if (Objects.nonNull(user)){
            if (user.getUsername().equals(dto.getUsername())){
                throw new QkBizException(QkBizExceptionInfoEnum.USER_NAME_EXIST);
            }
            if (user.getPhone().equals(dto.getPhone())){
                throw new QkBizException(QkBizExceptionInfoEnum.USER_PHONE_EXIST);
            }
            if (user.getEmail().equals(dto.getEmail())){
                throw new QkBizException(QkBizExceptionInfoEnum.USER_EMAIL_EXIST);
            }
        }
        // 保存用户业务逻辑
        user = BeanUtil.copyProperties(dto, User.class);
        // 对密码散列处理
        String encodePassword = DigestUtils.md5DigestAsHex((dto.getUsername() + "123").getBytes());
        user.setPassword(encodePassword);
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.insert(user);
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        userMapper.deleteByIds(ids);

    }
}
   