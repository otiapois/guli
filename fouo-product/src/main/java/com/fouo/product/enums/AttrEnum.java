package com.fouo.product.enums;


/**
 * 状态码枚举
 *
 * @author fouo
 * @date 2020/6/17 7:45
 */
public enum AttrEnum {

    ATTR_TYPE_BASE(1, "基本属性"),
    ATTR_TYPE_SALE(0, "销售属性");

    AttrEnum(int code, String msg) {
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
