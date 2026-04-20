package com.qk.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 33465
 * @created 2026/4/20 下午3:23
 * @desciption 角色添加请求信息封装类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleSaveDTO {

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
   