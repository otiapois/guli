package com.fouo;

import com.aliyun.oss.OSSClient;
import com.fouo.third.ThirdPartyApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ThirdPartyApplication.class)
public class OssDemo {

    @Resource
    private OSSClient ossClient;
    @Test
    public void fun1() throws FileNotFoundException {
//        // Endpoint以杭州为例，其它Region请按实际情况填写。
//        String endpoint = "oss-cn-beijing.aliyuncs.com";
//        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
//        String accessKeyId = "LTAI4G9SiV1QoMJiEFUTPHPa";
//        String accessKeySecret = "hmMDBLSB2GepTXhk9M5ehqQqwoXgLx";

        // 创建OSSClient实例。
//        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 上传文件流。
        InputStream inputStream = new FileInputStream("C:\\Users\\86155\\Desktop\\1.png");
        ossClient.putObject("fouomall", "6.png", inputStream);
        // 关闭OSSClient。
        ossClient.shutdown();
    }

    @Test
    public void testCode(){
        String code = String.valueOf(new Random().nextInt(899999) + 100000) + "_" + System.currentTimeMillis();
        System.out.println("存入redis中的验证码"+code);
        System.out.println("发送到手机中的验证码"+code.substring(0, 6));
    }
}
