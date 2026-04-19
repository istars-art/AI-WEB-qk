package com.qk.model.dto;

import lombok.Data;

/**
 * @author 33465
 * @created 2026/4/19 下午9:00
 * @desciption 分页DTO基类
 */
@Data
public class PageBaseDTO {
    private Integer page = 1;
    private Integer pageSize = 10;
}
   