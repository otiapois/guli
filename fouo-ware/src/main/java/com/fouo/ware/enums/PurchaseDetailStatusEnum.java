package com.fouo.ware.enums;

/**
 * 购买状态枚举
 *
 * @author fouo
 * @date 2020/7/19 15:21
 */
public enum PurchaseDetailStatusEnum {
    CREATED(0, "新建"),
    ASSINGED(1, "已分配"),
    BUYING(2, "正在采购"),
    FINISHED(3, "已完成"),
    HAS_ERROR(4, "采购失败");


    PurchaseDetailStatusEnum(int code, String msg) {
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

