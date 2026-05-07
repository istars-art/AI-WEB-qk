package com.qk.model.dto;

import lombok.Data;

/**
 * @author 33465
 * @created 2026/4/28 下午9:18
 * @desciption
 */

@Data
public class ActivityPage extends PageBaseDTO{
    private Integer channel;
    private Integer type;
    private Integer status;
}
   