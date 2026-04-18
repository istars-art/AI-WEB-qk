package com.qk.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author 33465
 * @created 2026/4/18 下午5:55
 * @desciption 部门列表VO对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeptVO {
    /**
     * 部门id,主键
     */
    private Integer id;
    /**
     * 部门名称
     */
    private String name;
    /**
     * 部门状态:0-停用，1-正常
     */
    private Integer status;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
   