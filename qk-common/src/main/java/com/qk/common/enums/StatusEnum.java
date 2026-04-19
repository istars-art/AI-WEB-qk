package com.qk.common.enums;

/**
 * @author 33465
 * @created 2026/4/19 上午10:15
 * @desciption 部门状态枚举类
 */
public enum StatusEnum implements Code{

    ENABLE(1, "启用"),
    DISABLE(0, "禁用");


    private final Integer value;
    private final String msg;

    StatusEnum(Integer value, String msg) {
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
   