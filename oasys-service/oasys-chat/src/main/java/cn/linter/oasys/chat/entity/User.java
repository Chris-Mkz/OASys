package cn.linter.oasys.chat.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 用户实体类
 * @author ChrisMo
 * @since 2022/11/01
 */
@Data
@ToString
@EqualsAndHashCode
public class User {

    /**
     * 用户名
     */
    private String username;
    /**
     * 姓名
     */
    private String fullName;
    /**
     * 用户头像
     */
    private String profilePicture;

}