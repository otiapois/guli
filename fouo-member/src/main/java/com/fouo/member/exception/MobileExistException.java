package com.fouo.member.exception;

/**
 * 手机号已存在异常
 *
 * @author fouo
 * @date 2020/8/20 16:34
 */
public class MobileExistException extends RuntimeException {
    public MobileExistException() {
        super("手机已注册说");
    }
}
