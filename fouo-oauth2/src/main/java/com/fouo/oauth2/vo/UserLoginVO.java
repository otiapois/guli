package com.fouo.oauth2.vo;

import lombok.Data;

/**
 * 用户登录VO
 * 用于封装用户登录信息
 *
 * @author fouo
 * @date 2020/8/21 15:20
 */
@Data
public class UserLoginVO {
    private String username;
    private String password;
}