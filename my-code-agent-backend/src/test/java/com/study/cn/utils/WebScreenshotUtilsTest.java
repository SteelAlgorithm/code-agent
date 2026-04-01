package com.study.cn.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WebScreenshotUtilsTest {



    @Test
    void saveWebPageScreenshot() {
        WebScreenshotUtils.saveWebPageScreenshot("https://www.aigei.com/design/pic/");
        System.out.println("==========");
    }
}