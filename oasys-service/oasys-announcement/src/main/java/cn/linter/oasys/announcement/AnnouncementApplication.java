package cn.linter.oasys.announcement;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ChrisMo
 * @since 2022/11/11
 */
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class AnnouncementApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnnouncementApplication.class, args);
        log.info("announcement-service已部署");
    }

}
