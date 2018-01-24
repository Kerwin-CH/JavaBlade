package com.huruwo.demo.bean;

import com.blade.jdbc.annotation.Table;
import com.blade.jdbc.core.ActiveRecord;
import lombok.Data;

/**
 * 用户
 *
 * @author biezhi
 */
@Data
@Table(value = "t_users", pk = "uid")
public class Users extends ActiveRecord {

    // user表主键
    private Integer uid;

    // 用户名称
    private String username;

    // 用户密码
    private String password;

    // 用户的邮箱
    private String email;

    private Long timestamp;

    private String token;

}