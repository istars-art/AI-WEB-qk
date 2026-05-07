package com.qk.management.service;

import com.qk.model.dto.LoginDTO;
import com.qk.model.vo.LoginVO;

/**
 * @author 33465
 * @created 2026/5/7 下午8:30
 * @desciption
 */

public interface LoginService{

    LoginVO login(LoginDTO loginDTO);
}
