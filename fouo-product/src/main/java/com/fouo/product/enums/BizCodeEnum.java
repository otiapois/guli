package com.fouo.product.enums;


/**
 * 状态码枚举
 *
 * @author fouo
 * @date 2020/6/17 7:45
 */
public enum BizCodeEnum {

    UNKONW_EXCEPTION(10000, "系统未知异常"),
    VALID_EXCEPTION(10001, "提交的数据不合法,请检查后重新提交！");


    BizCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }

    private int code;
    private String msg;
}
