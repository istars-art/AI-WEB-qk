package com.qk.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 部门实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dept implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id; // 部门id，主键
    private String name; // 部门名称
    private Integer status; // 状态：0-停用，1-正常
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 修改时间
}