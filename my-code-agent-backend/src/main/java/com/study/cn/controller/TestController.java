package com.study.cn.controller;

import com.study.cn.common.BaseResponse;
import com.study.cn.common.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试类
 * @Author: tom
 * @CreateTime: 2026-03-19
 * @Description:
 * @Version: 1.0
 */
@Slf4j
@RestController
public class TestController {

    @GetMapping("/test")
    public BaseResponse<String> test(String  name) {
//        int a = 1 / 0;
        log.info("测------------------------------------试");
        return ResultUtils.success(name);
    }
}
