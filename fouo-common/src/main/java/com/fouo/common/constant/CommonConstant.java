package com.fouo.common.constant;

/**
 * 通用常量
 *
 * @author fouo
 * @date 2020/6/4 17:05
 */
public interface CommonConstant {

    /**
     * 网关模块名称
     */
    String APPLICATION_GATEWAY_NAME = AppConstant.APPLICATION_GATEWAY_NAME + "gateway";

    /**
     * 优惠卷模块名称
     */
    String APPLICATION_COUPON_NAME = AppConstant.APPLICATION_NAME_PREFIX + "coupon";
    /**
     * 会员模块名称
     */
    String APPLICATION_MEMBER_NAME = AppConstant.APPLICATION_NAME_PREFIX + "member";
    /**
     * 订单模块名称
     */
    String APPLICATION_ORDER_NAME = AppConstant.APPLICATION_NAME_PREFIX + "order";
    /**
     * 商品模块名称
     */
    String APPLICATION_PRODUCT_NAME = AppConstant.APPLICATION_NAME_PREFIX + "product";
    /**
     * 第三方服务模块名称
     */
    String APPLICATION_THIRDPARTY_NAME = AppConstant.APPLICATION_NAME_PREFIX + "third-party";
    /**
     * 仓储模块名称
     */
    String APPLICATION_WARE_NAME = AppConstant.APPLICATION_NAME_PREFIX + "ware";

    /**
     * 仓储模块名称
     */
    String APPLICATION_ELASTICSEARCH_NAME = AppConstant.APPLICATION_NAME_PREFIX + "elasticsearch";
    /**
     * nacos dev 地址
     */
//	String NACOS_DEV_ADDR = "122.51.59.70:8848";

    //String NACOS_DEV_ADDR = "192.168.0.44:8848";

    String NACOS_DEV_ADDR = "192.168.127.131:8848";

    /**
     * nacos prod 地址
     */
    String NACOS_PROD_ADDR = "192.168.127.131:8848";

    /**
     * nacos test 地址
     */
    String NACOS_TEST_ADDR = "192.168.127.131:8848";

    /**
     * sentinel dev 地址
     */
    String SENTINEL_DEV_ADDR = "192.168.127.131:8858";

    /**
     * sentinel prod 地址
     */
    String SENTINEL_PROD_ADDR = "192.168.127.131:8858";

    /**
     * sentinel test 地址
     */
    String SENTINEL_TEST_ADDR = "192.168.127.131:8858";

    /**
     * 顶级父节点id
     */
    Long TOP_PARENT_ID = 0L;

    /**
     * 顶级父节点名称
     */
    String TOP_PARENT_NAME = "顶级";

    /**
     * 应用仓库地址
     */
    String HARBOR_IP = "";

    /**
     * SSH连接端口
     */
    String SSH_IP = "";

    /**
     * SSH登录用户名
     */
    String SSH_USERNAME = "";

    /**
     * SSH登录密码
     */
    String SSH_PASSWORD = "";

    /**
     * 默认密码
     */
    String DEFAULT_PASSWORD = "123456";

    /**
     * 动态获取nacos地址
     *
     * @param profile 环境变量
     * @return addr
     */
    static String nacosAddr(String profile) {
        switch (profile) {
            case (AppConstant.PROD_CODE):
                return NACOS_PROD_ADDR;
            case (AppConstant.TEST_CODE):
                return NACOS_TEST_ADDR;
            default:
                return NACOS_DEV_ADDR;
        }
    }

    /**
     * 动态获取sentinel地址
     *
     * @param profile 环境变量
     * @return addr
     */
    static String sentinelAddr(String profile) {
        switch (profile) {
            case (AppConstant.PROD_CODE):
                return SENTINEL_PROD_ADDR;
            case (AppConstant.TEST_CODE):
                return SENTINEL_TEST_ADDR;
            default:
                return SENTINEL_DEV_ADDR;
        }
    }
}
