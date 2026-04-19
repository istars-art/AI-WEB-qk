package com.qk.management.handler;

import com.qk.common.Result;
import com.qk.common.exception.QkBizException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

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
    @ExceptionHandler
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(", "));
        return Result.error(message);
    }

    @ExceptionHandler
    public Result handleBindException(BindException e) {
        String message = e.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(", "));
        return Result.error(message);
    }
}
   