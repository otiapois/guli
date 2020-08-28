package com.fouo.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.fouo.member.entity.Member;
import com.fouo.member.entity.MemberLevel;
import com.fouo.member.exception.MobileExistException;
import com.fouo.member.exception.UsernameExistException;
import com.fouo.member.mapper.MemberLevelMapper;
import com.fouo.member.vo.MemberRegistVO;
import com.fouo.member.vo.MemberVO;
import com.fouo.member.mapper.MemberMapper;
import com.fouo.member.service.IMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fouo.member.vo.SocialUserVO;
import com.fouo.member.vo.UserLoginVO;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * 会员 服务实现类
 *
 * @author fouo
 * @since 2020-06-02
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements IMemberService {

    @Autowired
    private MemberLevelMapper memberLevelMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public IPage<MemberVO> selectMemberPage(IPage<MemberVO> page, MemberVO member) {
        return page.setRecords(baseMapper.selectMemberPage(page, member));
    }

    @Override
    public boolean regist(MemberRegistVO memberRegistVO) {
        Member member = new Member();
        //检查用户名和手机号是否唯一
        checkMobileUnique(memberRegistVO.getPhone());
        checkUsernameUnique(memberRegistVO.getUserName());

        //封装手机号和用户名
        member.setMobile(memberRegistVO.getPhone());
        member.setUsername(memberRegistVO.getUserName());
        member.setNickname(memberRegistVO.getUserName());
        //封装密码 主要密码要进行加密
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        member.setPassword(encoder.encode(memberRegistVO.getPassword()));

        //设置默认等级
        MemberLevel level = memberLevelMapper.getDefaultLevel();
        member.setLevelId(level.getId());

        baseMapper.insert(member);
        return true;
    }

    @Override
    public void checkUsernameUnique(String userName) throws UsernameExistException {
        Integer count = baseMapper.selectCount(new QueryWrapper<Member>().eq("username", userName));
        if (count > 0) {
            throw new UsernameExistException();
        }
    }

    @Override
    public void checkMobileUnique(String phone) throws MobileExistException {
        Integer count = baseMapper.selectCount(new QueryWrapper<Member>().eq("mobile", phone));
        if (count > 0) {
            throw new MobileExistException();
        }
    }

    /*
     * 只要返回一个null值，则表明登录失败
     * 登录成功后返回一个member对象
     */
    @Override
    public Member login(UserLoginVO userLoginVO) {
        //获取用户登录时传递过来的用户名 密码
        String username = userLoginVO.getUsername();
        String password = userLoginVO.getPassword();

        //去数据库查询
        Member member = baseMapper.selectOne(new QueryWrapper<Member>().eq("username", username).or().eq("mobile", username));
        if (member == null) {
            //登录失败
            return null;
        } else {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            //获取数据库中的密码值
            String dbPassword = member.getPassword();
            //进行密码匹配
            if (encoder.matches(password, dbPassword)) {
                return member;
            } else {
                return null;
            }
        }
    }

    @Override
    public Member socialLogin(SocialUserVO socialUserVO) {
        Gson gson = new Gson();
        //登录和注册合并逻辑
        String uid = socialUserVO.getUid();
        //判断当前社交用户是否已经登录过系统
        Member member = baseMapper.selectOne(new QueryWrapper<Member>().eq("social_uid", uid));
        if (member != null) {
            //TODO 后期需要验证该步操作是否有问题  或者可以有优化空间 感觉有点啰嗦
            //这个用户已经注册过了(则代表登录) 需要更新token以及更新token的过期时间
            Member updateMember = new Member();

            updateMember.setId(member.getId());
            updateMember.setAccessToken(socialUserVO.getAccess_token());
            updateMember.setExpiresIn(socialUserVO.getExpires_in());

            //更新数据
            baseMapper.updateById(updateMember);
            member.setAccessToken(socialUserVO.getAccess_token());
            member.setExpiresIn(socialUserVO.getExpires_in());
            return member;
        } else {
            //没有查到当前社交用户对应的用户 则需要注册一个
            Member regist = new Member();

            try {
                //查询当前社交用户的社交账号信息
                String uri = "https://api.weibo.com/2/users/show.json?access_token=" + socialUserVO.getAccess_token() + "&uid=" + socialUserVO.getUid();
                String json = restTemplate.getForObject(uri, String.class);
                if (StringUtils.isNotEmpty(json)) {
                    Map<String, String> map = gson.fromJson(json, Map.class);
                    //获取微博昵称
                    String name = map.get("name");
                    //获取性别
                    String gender = map.get("gender");
                    //获取头像
                    String image = map.get("profile_image_url");

                    regist.setNickname(name);

                    if (gender.equals("m")) {
                        regist.setGender(1);
                    } else {
                        regist.setGender(0);
                    }
                    regist.setHeader(image);
                }
            } catch (Exception e) {

            }
            regist.setSocialUid(socialUserVO.getUid());
            regist.setAccessToken(socialUserVO.getAccess_token());
            regist.setExpiresIn(socialUserVO.getExpires_in());
            //将实体注册到数据库中
            baseMapper.insert(regist);
            return regist;
        }
    }

}
