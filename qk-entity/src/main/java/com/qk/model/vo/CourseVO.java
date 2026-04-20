package com.qk.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author 33465
 * @created 2026/4/20 下午5:47
 * @desciption 课程数据响应类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseVO {
    private Integer id; //课程id，主键
    private Integer subject; //课程学科，1:AI智能应用开发(Java), 2:AI大模型开发(Python)，3:AI鸿蒙开发，4:AI大数据，5:AI嵌入式，6:AI测试，7:AI运维
    private String name; //课程名称
    private Integer price; //课程价格（元）
    private Integer target; //适用人群, 1:小白学员, 2:中级程序员
    private String description; //课程介绍
    private LocalDateTime createTime; //创建时间

}
   