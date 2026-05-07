package com.qk.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 33465
 * @created 2026/5/7 下午2:56
 * @desciption
 */
@Data
public class ActivitySaveDTO {


    /**
     * 渠道来源，1:线上活动, 2:推广介绍
     */
    private Integer channel;

    /**
     * 活动名称
     */
    private String name;

    /**
     * 开始时间
     */
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    private LocalDateTime endTime;

    /**
     * 活动简介
     */
    private String description;

    /**
     * 活动类型，1:课程折扣, 2:代金券
     */
    private Integer type;

    /**
     * 课程折扣
     */
    private Double discount;

    /**
     * 代金券金额（元）
     */
    private Integer voucher;

}
   