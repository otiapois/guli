package com.fouo.member.exception;

/**
 * 用户名已存在异常
 *
 * @author fouo
 * @date 2020/8/20 16:34
 */
public class UsernameExistException extends RuntimeException{
    public UsernameExistException() {
        super("用户名已注册");
    }
}
