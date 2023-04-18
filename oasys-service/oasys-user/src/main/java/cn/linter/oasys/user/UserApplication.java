package cn.linter.oasys.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 用户服务启动类
 * @author ChrisMo
 * @since 2022/11/12
 */
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
        log.info("user-service已部署");
    }

}
