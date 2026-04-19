package com.qk.management.handler;

import com.qk.common.Result;
import com.qk.common.exception.QkBizException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 33465
 * @created 2026/4/19 上午10:05
 * @desciption 全局异常处理器
 */
@RestControllerAdvice
public class QkGlobalExceptionHandler {
    @ExceptionHandler
    public Result QkBizExceptionHandler(QkBizException e){
        return Result.error(e.getMessage());
    }
}
   