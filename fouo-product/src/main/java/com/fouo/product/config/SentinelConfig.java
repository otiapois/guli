package com.fouo.product.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.adapter.servlet.callback.WebCallbackManager;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fouo.common.support.R;
import com.google.gson.Gson;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Sentinel配置类
 * <p>
 * 用于自定义sentinel的数据 规则 返回 等
 *
 * @author fouo
 * @date 2020/9/23 15:57
 */
@Configuration
public class SentinelConfig {
    Gson gson = new Gson();
    public SentinelConfig() {
        /**
         * 设置请求被限制之后的处理器
         */
        WebCallbackManager.setUrlBlockHandler(new UrlBlockHandler() {
            @Override
            public void blocked(HttpServletRequest request, HttpServletResponse response, BlockException ex) throws IOException {
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json");
                response.getWriter().write( gson.toJson(R.fail("当前流量过大,请稍后重试")));
            }
        });
    }
}
