///*
//package com.fouo.gateway.dynamic.service;
//
//import com.alibaba.cloud.nacos.NacosConfigProperties;
//import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
//import com.alibaba.fastjson.JSON;
//import com.alibaba.nacos.api.NacosFactory;
//import com.alibaba.nacos.api.config.ConfigService;
//import com.alibaba.nacos.api.config.listener.Listener;
//import com.alibaba.nacos.api.exception.NacosException;
//import com.fouo.gateway.constant.NacosConstant;
//import com.fouo.gateway.props.FouoProperties;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.gateway.route.RouteDefinition;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.concurrent.Executor;
//
//*/
///**
// * 动态路由监听器
// *
// * @author Chill
// *//*
//
//@Order
//@Slf4j
//@Component
//public class DynamicRouteServiceListener {
//
//    private final DynamicRouteService dynamicRouteService;
//    private final NacosDiscoveryProperties nacosDiscoveryProperties;
//    private final NacosConfigProperties nacosConfigProperties;
//    private final FouoProperties fouoProperties;
//
//    public DynamicRouteServiceListener(DynamicRouteService dynamicRouteService, NacosDiscoveryProperties nacosDiscoveryProperties, NacosConfigProperties nacosConfigProperties, FouoProperties fouoProperties) {
//        this.dynamicRouteService = dynamicRouteService;
//        this.nacosDiscoveryProperties = nacosDiscoveryProperties;
//        this.nacosConfigProperties = nacosConfigProperties;
//        this.fouoProperties = fouoProperties;
//        dynamicRouteServiceListener();
//    }
//
//    */
///**
//     * 监听Nacos下发的动态路由配置
//     *//*
//
//    private void dynamicRouteServiceListener() {
//        try {
//            String dataId = NacosConstant.dataId( fouoProperties.getName(), fouoProperties.getEnv(), NacosConstant.NACOS_CONFIG_JSON_FORMAT );
//            String group = nacosConfigProperties.getGroup();
//            String serverAddr = nacosDiscoveryProperties.getServerAddr();
//            ConfigService configService = NacosFactory.createConfigService( serverAddr );
//            configService.addListener( dataId, group, new Listener() {
//                @Override
//                public void receiveConfigInfo(String configInfo) {
//                    List<RouteDefinition> routeDefinitions = JSON.parseArray( configInfo, RouteDefinition.class );
//                    dynamicRouteService.updateList( routeDefinitions );
//                }
//
//                @Override
//                public Executor getExecutor() {
//                    return null;
//                }
//            } );
//        } catch (NacosException ignored) {
//
//        }
//    }
//
//}
//*/
