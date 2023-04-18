package cn.linter.oasys.auth.controller;

import cn.linter.oasys.auth.client.UserClient;
import cn.linter.oasys.auth.entity.Permission;
import cn.linter.oasys.auth.entity.User;
import cn.linter.oasys.common.entity.Result;
import cn.linter.oasys.common.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户控制器
 *
 * @author ChrisMo
 * @since 2023/1/21
 */
@RestController
@RequestMapping("oauth")
public class UserController {

    @Autowired
    private UserClient userClient;



    /**
     * 获取用户信息
     * @param token
     * @return
     */
    @GetMapping("user")
    public Result<User> getUser(@RequestHeader("Authorization") String token) {
        Result<User> result = userClient.queryUser(JwtUtil.getUsername(token));
        result.getData().setPassword(null);
        return result;
    }

    /**
     * 获取用户权限
     * @param token
     * @return
     */
    @GetMapping("user/permissions")
    public Result<List<Permission>> getPermissionsOfUser(@RequestHeader("Authorization") String token) {
        return userClient.listPermissionOfUser(JwtUtil.getUsername(token), true);
    }

}
