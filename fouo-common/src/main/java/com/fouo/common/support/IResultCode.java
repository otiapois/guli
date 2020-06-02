package com.fouo.common.support;

/**
 * 业务代码接口
 *
 * @author fouo
 */
public interface IResultCode {
    /**
     * 获取消息
     *
     * @return
     */
    String getMessage();

    /**
     * 获取状态码
     *
     * @return
     */
    int getCode();
}
