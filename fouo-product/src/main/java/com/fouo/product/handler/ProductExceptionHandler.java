package com.fouo.product.handler;

import com.fouo.common.support.R;
import com.fouo.product.enums.BizCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 商品微服务异常同一处理类
 *
 * @author fouo
 * @date 2020/6/16 17:51
 * @ControllerAdvice 用于异常的统一处理
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.fouo.product.controller")
public class ProductExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleVaildException(MethodArgumentNotValidException e) {
        //日志记录
        log.error("数据校验出现问题{},异常类型{}", e.getMessage(), e.getClass());
        BindingResult bindingResult = e.getBindingResult();
        Map<String,String> map = new HashMap<>();
        bindingResult.getFieldErrors().forEach((item) -> {
            //获取错误校验消息
            String defaultMessage = item.getDefaultMessage();
            //获取错误字段的字段名称
            String fileName = item.getField();
            map.put(fileName, defaultMessage);
        });
        return R.data(BizCodeEnum.VALID_EXCEPTION.getCode(), map,BizCodeEnum.VALID_EXCEPTION.getMsg()) ;
    }

//    @ExceptionHandler(value = Throwable.class)
//    public R handleException(Throwable e) {
//        return  R.fail("");
//    }
}
