package com.fouo.oauth2.vo;

import lombok.Data;

/**
 * 社交用户实体类 用于封装token的json串
 *
 * @author fouo
 * @date 2020/8/24 14:52
 */
@Data
public class SocialUserVO {
    private String access_token;
    private String remind_in;
    private long expires_in;
    private String uid;
    private String isRealName;
}
