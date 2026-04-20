package com.qk.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * @author 33465
 * @created 2026/4/20 下午4:39
 * @desciption
 */
@Data
public class RoleUpdateDTO {
    //角色id
    @NotNull(message = "角色id不能为空")
    private Integer id;

    //角色名称，必填，限制输入2-10个字，验证唯一性
    @NotBlank(message = "角色名称不能为空")
    @Size(min = 2,max = 10,message = "名称长度必须在2~10之间")
    private String name;

    // 角色标识，必填，限制输入 2-20个字母，验证唯一性
    @Size(min = 2,max = 20,message = "标识长度必须在2~20之间")
    @NotBlank(message = "角色标识不能为空")
    private String label;

    //备注，选填，手动输入，50字以内
    @Size(max = 50,message = "备注长度不能超过50字")
    private String remark;
}
   