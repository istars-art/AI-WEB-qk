package com.qk.model.dto;

import lombok.Data;

/**
 * @author 33465
 * @created 2026/4/20 下午5:45
 * @desciption 课程分页请求类
 */
@Data
public class CoursePage extends PageBaseDTO{
    private String name;
    private Integer subject;
    private Integer target;

}
   