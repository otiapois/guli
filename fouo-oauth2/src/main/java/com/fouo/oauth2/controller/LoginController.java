package com.fouo.oauth2.controller;

import com.fouo.common.support.R;
import com.fouo.common.vo.MemberSocialVO;
import com.fouo.oauth2.constant.AuthServerConstant;
import com.fouo.oauth2.feign.IMemberClinet;
import com.fouo.oauth2.feign.IThirdPartClinet;
import com.fouo.oauth2.vo.MemberRegistVO;
import com.fouo.oauth2.vo.UserLoginVO;
import com.fouo.oauth2.vo.UserRegistVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/oauth2/sms")
public class LoginController {
    @Autowired
    private IMemberClinet iMemberClinet;
    @Autowired
    private IThirdPartClinet iThirdPartClinet;
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 调用第三方短信服务 发送验证码
     *
     * @param phone 发送的手机号
     * @return
     */
    @GetMapping("/sendcode")
    public R sendCode(@RequestParam("phone") String phone) {
        //TODO 接口防止刷新

        long redisTime = 0L;
        String redisCode = redisTemplate.boundValueOps(AuthServerConstant.SMS_CODE_CACHE_PREFIX + phone).get();
        if (StringUtils.isNotEmpty(redisCode)) {
            redisTime = Long.parseLong(redisCode.split("_")[1]);
        }

        if (System.currentTimeMillis() - redisTime < 60000) {
            //60内不能再次发送验证码
            return R.fail("60内不能再次发送验证码");
        }
        //生成6位的随机验证码
        String code = String.valueOf(new Random().nextInt(899999) + 100000) + "_" + System.currentTimeMillis();
        //验证码的再次校验 redis 验证码格式  sms:code:手机号 验证码过期时间 5min 防止同一个手机号在60s内再次发送验证码
        redisTemplate.boundValueOps(AuthServerConstant.SMS_CODE_CACHE_PREFIX + phone).set(code, 5, TimeUnit.MINUTES);
        //调用第三方服务发送验证码
        R r = iThirdPartClinet.sendCode(phone, code.substring(0, 6));
        return R.status(r.isSuccess());
    }

    /**
     * 用户注册
     * RedirectAttributes redirectAttributes 重定向携带数据
     *
     * @param userRegistVO 用户注册信息封装实体类
     * @return
     */
    @PostMapping("/regist")
    public String regist(@Valid UserRegistVO userRegistVO, BindingResult result, RedirectAttributes redirectAttributes) {

        //进行校验
        if (result.hasErrors()) {
//            Map<String, String> map = new HashMap<>();
//            result.getFieldErrors().stream().map(errors ->{
//                String field = errors.getField();
//                String defaultMessage = errors.getDefaultMessage();
//                map.put(field,defaultMessage);
//            });

            Map<String, String> map = result.getFieldErrors().stream().collect(Collectors.toMap(errors -> {
                return errors.getField();
            }, errors -> {
                return errors.getDefaultMessage();
            }));
//            model.addAttribute("errors", map);
            redirectAttributes.addFlashAttribute("errors", map);

            //如果校验出错 转发到注册页
            return "redirect:http://oauth2.fouomall.com/reg.html";
        }


        //调用远程服务进行注册
        String code = userRegistVO.getCode();//获取前端页面用户通过手机获取后
        String redisCode = redisTemplate.boundValueOps(AuthServerConstant.SMS_CODE_CACHE_PREFIX + userRegistVO.getPhone()).get();

        if (StringUtils.isNotEmpty(redisCode)) {
            if (code.equals(redisCode.substring(0, 6))) {
                //删除验证码
                redisTemplate.delete(AuthServerConstant.SMS_CODE_CACHE_PREFIX + userRegistVO.getPhone());
                //验证码通过
                MemberRegistVO memberRegistVO = new MemberRegistVO();
                BeanUtils.copyProperties(userRegistVO, memberRegistVO);
                R res = iMemberClinet.regist(memberRegistVO);
                if (res.getCode() == 200) {
                    //注册成功  返回登录页面
                    return "redirect:http://oauth2.fouomall.com/login.html";
                } else {
                    Map<String, String> errors = new HashMap<>();
                    errors.put("msg", res.getMsg());
                    redirectAttributes.addFlashAttribute("errors", errors);
                    return "redirect:http://oauth2.fouomall.com/reg.html";
                }
            } else {
                Map<String, String> errors = new HashMap<>();
                errors.put("code", "验证码错误");
                redirectAttributes.addFlashAttribute("errors", errors);
                //校验出错 转发到注册页
                return "redirect:http://oauth2.fouomall.com/reg.html";
            }
        } else {
            Map<String, String> errors = new HashMap<>();
            errors.put("code", "验证码错误");
            redirectAttributes.addFlashAttribute("errors", errors);
            //校验出错 转发到注册页
            return "redirect:http://oauth2.fouomall.com/reg.html";
        }
    }

    @PostMapping("/login")
    public String login(UserLoginVO userLoginVO, RedirectAttributes redirectAttributes, HttpSession session) {
        R<MemberSocialVO> result = iMemberClinet.login(userLoginVO);
        if (result.getCode() == 200) {
            log.info(result.getData().toString());
            session.setAttribute(AuthServerConstant.LOGIN_USER, result.getData());
            //登录成功
            return "redirect:http://fouomall.com";
        } else {
            Map<String, String> errors = new HashMap<>();
            errors.put("msg", result.getMsg());
            redirectAttributes.addFlashAttribute("errors", errors);
            return "redirect:http://oauth2.fouomall.com/login.html";
        }
    }


}
