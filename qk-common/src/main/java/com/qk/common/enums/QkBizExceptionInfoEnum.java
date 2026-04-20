package com.qk.common.enums;

/**
 * @author 33465
 * @created 2026/4/19 上午9:47
 * @desciption 异常信息枚举类
 */
public enum QkBizExceptionInfoEnum implements Code{

    DEPT_NOT_EXIST(1001, "部门不存在"),
    DEPT_STATUS_INVALID(1002, "部门状态不合法"),
    DEPT_NAME_REPEAT(1003, "部门名称重复"),
    ROLE_NOT_EXIST(2001, "角色不存在"),
    ROLE_REPEAT(1003, "角色名称或角色标识重复"),
    ;

    private final Integer value;
    private final String msg;

    QkBizExceptionInfoEnum(Integer value, String msg) {
        this.value = value;
        this.msg = msg;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }
}
   