package com.fouo.common.constant;

/**
 * 系统常量
 *
 * @author fouo
 * @date 2020/6/4 17:06
 */
public interface AppConstant {
    /**
     * 基础包
     */
    String BASE_PACKAGES = "com.fouo";

    /**
     * 应用名前缀
     */
    String APPLICATION_NAME_PREFIX = "fouo-";

    /**
     * 网关模块名称
     */
    String APPLICATION_GATEWAY_NAME = APPLICATION_NAME_PREFIX + "gateway";
    /**
     * 优惠卷模块名称
     */
    String APPLICATION_COUPON_NAME = APPLICATION_NAME_PREFIX + "coupon";
    /**
     * 会员模块名称
     */
    String APPLICATION_MEMBER_NAME = APPLICATION_NAME_PREFIX + "member";
    /**
     * 订单模块名称
     */
    String APPLICATION_ORDER_NAME = APPLICATION_NAME_PREFIX + "order";
    /**
     * 商品模块名称
     */
    String APPLICATION_PRODUCT_NAME = APPLICATION_NAME_PREFIX + "product";
    /**
     * 第三方服务模块名称
     */
    String APPLICATION_THIRDPARTY_NAME = APPLICATION_NAME_PREFIX + "third-party";
    /**
     * 仓储模块名称
     */
    String APPLICATION_WARE_NAME = APPLICATION_NAME_PREFIX + "ware";

    /**
     * 开发环境
     */
    String DEV_CODE = "dev";
    /**
     * 生产环境
     */
    String PROD_CODE = "prod";
    /**
     * 测试环境
     */
    String TEST_CODE = "test";

    /**
     * 代码部署于 linux 上，工作默认为 mac 和 Windows
     */
    String OS_NAME_LINUX = "LINUX";
}
