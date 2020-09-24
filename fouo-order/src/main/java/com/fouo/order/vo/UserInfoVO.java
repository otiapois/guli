package com.fouo.order.vo;

import lombok.Data;

/**
 * @author fouo
 * @date 2020/9/1 10:29
 */
@Data
public class UserInfoVO {
    private Long userId;
    private String userKey;
    private Boolean tempUser = false;
}
