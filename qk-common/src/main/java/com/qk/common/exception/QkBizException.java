package com.qk.common.exception;

import com.qk.common.enums.Code;

/**
 * @author 33465
 * @created 2026/4/19 上午9:40
 * @desciption 异常类
 */
public class QkBizException extends RuntimeException{
    public QkBizException(Code code) {
        super(code.getMsg());
    }
}
   