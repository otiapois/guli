package com.fouo.oauth2.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

/**
 * 用户注册实现类
 *
 * @author fouo
 * @date 2020/8/20 11:19
 */
@Data
public class UserRegistVO {

    @NotEmpty(message = "用户名称必须提交")
    @Length(min = 6, max = 18, message = "用户名称必须是6-18位字符")
    private String userName;

    @NotEmpty(message = "密码不能为空")
    @Length(min = 6, max = 18, message = "密码必须是6-18位字符")
    private String password;

    @NotEmpty(message = "手机号不能为空")
    private String phone;
    @NotEmpty(message = "验证码不能为空")
    private String code;
}
