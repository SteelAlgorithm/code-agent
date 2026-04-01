package com.study.cn.config;


import com.study.cn.monitor.AiModelMonitorListener;
import dev.langchain4j.model.chat.StreamingChatModel;
import dev.langchain4j.model.openai.OpenAiStreamingChatModel;
import jakarta.annotation.Resource;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * 推理流式模型配置
 * @Author: tom
 * @CreateTime: 2026-03-19
 * @Description:
 * @Version: 1.0
 */
//@Configuration
//@ConfigurationProperties(prefix = "langchain4j.open-ai.chat-model")
//@Data
//public class ReasoningStreamingChatModelConfig {
//
//    private String baseUrl;
//
//    private String apiKey;
//
//    /**
//     * 推理流式模型（用于 Vue 项目生成，带工具调用）
//     */
//    @Bean
//    public StreamingChatModel reasoningStreamingChatModel() {
//        // 为了测试方便临时修改
//        final String modelName = "deepseek-chat";
//        final int maxTokens = 8192;
//        // 生产环境使用：
//        // final String modelName = "deepseek-reasoner";
//        // final int maxTokens = 32768;
//        return OpenAiStreamingChatModel.builder()
//                .apiKey(apiKey)
//                .baseUrl(baseUrl)
//                .modelName(modelName)
//                .maxTokens(maxTokens)
//                .logRequests(true)
//                .logResponses(true)
//                .build();
//    }
//}
@Configuration
@ConfigurationProperties(prefix = "langchain4j.open-ai.reasoning-streaming-chat-model")
@Data
public class ReasoningStreamingChatModelConfig {

    @Resource
    private AiModelMonitorListener aiModelMonitorListener;

    private String baseUrl;

    private String apiKey;

    private String modelName;

    private Integer maxTokens;

    private Double temperature;

    private Boolean logRequests = false;

    private Boolean logResponses = false;

    /**
     * 推理流式模型（用于 Vue 项目生成，带工具调用）
     */
    @Bean
    @Scope("prototype")
    public StreamingChatModel reasoningStreamingChatModelPrototype() {
        return OpenAiStreamingChatModel.builder()
                .apiKey(apiKey)
                .baseUrl(baseUrl)
                .modelName(modelName)
                .maxTokens(maxTokens)
                .temperature(temperature)
                .logRequests(logRequests)
                .logResponses(logResponses)
                .listeners(List.of(aiModelMonitorListener))
                .build();
    }
}
