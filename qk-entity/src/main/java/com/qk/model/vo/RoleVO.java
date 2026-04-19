package com.qk.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author 33465
 * @created 2026/4/19 下午8:47
 * @desciption 角色列表VO对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleVO {

    private Integer id; // 角色id，主键
    private String name; // 角色名称
    private String label; // 角色标识
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 修改时间

}
   