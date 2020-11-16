package com.fouo.member.vo;

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
public class MemberRegistVO {

    private String userName;

    private String password;

    private String phone;
}
