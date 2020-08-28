package com.fouo.member;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MemberApplication.class)
public class MemberTest {

    public final String salt = "自定义的一个盐";
    @Test
    public void test(){
        //生成MD5密文
        String md5 = DigestUtils.md5Hex("123456");
        System.out.println(md5);
        //对MD5进行加盐
        String md5Crypt = Md5Crypt.md5Crypt("123456".getBytes());
        System.out.println(md5Crypt);
        String md5CryptSalt = Md5Crypt.md5Crypt("123456".getBytes(),"$1$aaaaaaaa");
        System.out.println(md5CryptSalt);
        /**
         * spring提供的密码编码器
         */
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode("123456");
        boolean flag = encoder.matches("123456", "$2a$10$74zaIucq6KMv/wABLje0n.RVSkE3b3X7qXe6O7EzBm.F6L8vYjWSK");
        System.out.println(encode);
        System.out.println(flag);
    }
}
