package cn.linter.oasys.gateway.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 权限和角色映射数据传输对象
 * @author ChrisMo
 * @since 2023/1/21
 */
@Data
@ToString
public class PermissionRoleDTO {

    private PermissionDTO permission;

    private List<RoleDTO> roles;

}
