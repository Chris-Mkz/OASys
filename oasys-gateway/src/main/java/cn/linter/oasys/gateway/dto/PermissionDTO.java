package cn.linter.oasys.gateway.dto;

import lombok.Data;
import org.springframework.http.HttpMethod;

/**
 * 权限实体类
 *
 * @author ChrisMo
 * @since 2023/01/14
 */
@Data
public class PermissionDTO {

    /**
     * 资源路径
     */
    private String resourcePath;
    /**
     * 请求方法
     */
    private HttpMethod requestMethod;

}