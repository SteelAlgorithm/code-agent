package com.study.cn.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 密码加密工具类
 * @Author: tom
 * @CreateTime: 2026-03-19
 * @Description:
 * @Version: 1.0
 */

public class PasswordEncoderUtil {

    private static final BCryptPasswordEncoder encoder =
            new BCryptPasswordEncoder();

    /**
     * 加密密码
     */
    public static String encode(String rawPassword) {
        return encoder.encode(rawPassword);
    }

    /**
     * 校验密码
     */
    public static boolean matches(String rawPassword, String encodedPassword) {
        return encoder.matches(rawPassword, encodedPassword);
    }

    public static void main(String[] args) {

        String password = "12345678";

        String hash = encode(password);

        System.out.println("加密密码:"+hash);

        System.out.println(matches("12345678", "$2a$10$BnZC6iK.VzEh4DKrjWc.aeuIuMg6dZRohB2USDEjMNbiXs/TmSB.q"));
    }
}