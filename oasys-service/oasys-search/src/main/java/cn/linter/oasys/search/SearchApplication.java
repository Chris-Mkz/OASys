package cn.linter.oasys.search;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 搜索服务启动类
 * @author Chris
 * @since 2022/11/12
 */
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class SearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchApplication.class, args);
        log.info("search-service");
    }

}
