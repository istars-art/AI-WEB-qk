package com.qk.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 角色实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id; // 角色id，主键
    private String name; // 角色名称
    private String label; // 角色标识
    private String remark; // 备注
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 修改时间
}