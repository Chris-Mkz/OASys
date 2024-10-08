package cn.linter.oasys.attendance;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 考勤服务启动类
 * @author ChrisMo
 * @since 2022/11/11
 */
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class AttendanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AttendanceApplication.class, args);
        log.info("attendance-service已部署");
    }

}
