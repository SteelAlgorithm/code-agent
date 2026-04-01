package com.study.cn.ai;

import com.study.cn.ai.model.HtmlCodeResult;
import com.study.cn.ai.model.MultiFileCodeResult;
import com.study.cn.core.AiCodeGeneratorFacade;
import com.study.cn.model.enums.CodeGenTypeEnum;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class AiCodeGeneratorServiceTest {

    @Resource
    private AiCodeGeneratorService aiCodeGeneratorService;

    @Resource
    private AiCodeGeneratorFacade aiCodeGeneratorFacade;

    @Test
    void generateHtmlCode() {
        HtmlCodeResult result = aiCodeGeneratorService.generateHtmlCodeNew(123,"做个程序员tom的工作记录小工具，要求不超过50行代码");
        log.error("result:{}", result);
        Assertions.assertNotNull(result);
    }

    @Test
    void generateMultiFileCode() {
        MultiFileCodeResult multiFileCode = aiCodeGeneratorService.generateMultiFileCode("做个程序员鱼皮的留言板，要求不超过50行代码");
        System.out.println("输出结果:"+multiFileCode);
        Assertions.assertNotNull(multiFileCode);
    }

    @Test
    void testChatMemory() {
        HtmlCodeResult result = aiCodeGeneratorService.generateHtmlCodeNew(1, "做个登录界面，总代码量不超过 20 行");
        Assertions.assertNotNull(result);
        result = aiCodeGeneratorService.generateHtmlCodeNew(1, "不要生成网站，告诉我你刚刚做了什么？");
        System.err.println("输出结果:"+result);
        Assertions.assertNotNull(result);
//        result = aiCodeGeneratorService.generateHtmlCodeNew(2, "做个图书管理界面，总代码量不超过 20 行");
//        Assertions.assertNotNull(result);
//        result = aiCodeGeneratorService.generateHtmlCodeNew(2, "不要生成网站，告诉我你刚刚做了什么？");
//        Assertions.assertNotNull(result);
    }

    @Test
    void generateVueProjectCodeStream() {
        Flux<String> codeStream = aiCodeGeneratorFacade.generateAndSaveCodeStream(
                "简单的任务记录网站，总代码量不超过 200 行",
                CodeGenTypeEnum.VUE_PROJECT, 1L);
        // 阻塞等待所有数据收集完成
        List<String> result = codeStream.collectList().block();
        // 验证结果
        Assertions.assertNotNull(result);
        String completeContent = String.join("", result);
        Assertions.assertNotNull(completeContent);
    }


}
