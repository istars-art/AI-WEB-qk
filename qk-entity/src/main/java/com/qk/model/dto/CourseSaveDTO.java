package com.qk.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * @author 33465
 * @created 2026/4/20 下午6:17
 * @desciption 课程保存数据封装实体类
 */
@Data
public class CourseSaveDTO {

    @NotNull(message = "课程学科不能为空")
    private Integer subject; //课程学科，1:AI智能应用开发(Java), 2:AI大模型开发(Python)，3:AI鸿蒙开发，4:AI大数据，5:AI嵌入式，6:AI测试，7:AI运维

    @Size(min = 2,max = 20,message = "课程名称长度必须在2-20个字符之间")
    @NotNull(message = "课程名称不能为空")
    private String name; //课程名称

    @Size(min = 1,max = 5,message = "课程价格长度必须在1-5个字符之间")
    @NotNull(message = "课程价格不能为空")
    private Integer price; //课程价格（元）

    @NotNull(message = "适用人群不能为空")
    private Integer target; //适用人群, 1:小白学员, 2:中级程序员

    @Size(max = 100,message = "课程介绍长度必须在100个字符之内")
    private String description; //课程介绍

}
   