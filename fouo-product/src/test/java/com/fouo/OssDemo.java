package com.fouo;

import com.aliyun.oss.OSSClient;
import com.fouo.product.ProductApplication;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductApplication.class)
public class OssDemo {

    @Resource
    private OSSClient ossClient;

    @Autowired
    private RedissonClient redissonClient;

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
        ossClient.putObject("fouomall", "4.png", inputStream);
        // 关闭OSSClient。
        ossClient.shutdown();
    }

    @Test
    public void testRedissonClient(){
        RLock lock = redissonClient.getLock("my-test-lock");
        //加锁
//        lock.lock(); 有看门狗机制 不过不推荐
        //一般推荐自己设定解锁时间，没有看门狗机制   推荐的是给一个大一点的解锁时间。
        lock.lock(30, TimeUnit.SECONDS);

        //执行业务代码
        try{
            System.out.println("加锁成功,执行业务.");
            Thread.sleep(30000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //释放锁
            System.out.println("锁释放成功.");
            lock.unlock();
        }

    }
}
