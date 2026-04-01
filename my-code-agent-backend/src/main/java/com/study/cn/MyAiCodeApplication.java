package com.study.cn;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author: tom
 * @CreateTime: 2026-03-19
 * @Description:
 * @Version: 1.0
 */

@EnableCaching
@SpringBootApplication(exclude = {
        dev.langchain4j.community.store.embedding.redis.spring.RedisEmbeddingStoreAutoConfiguration.class
})
@MapperScan("com.study.cn.mapper")
public class MyAiCodeApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MyAiCodeApplication.class, args);



        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

        System.out.println("========== ChatMemory Beans ==========");
        String[] chatMemoryBeans = beanFactory.getBeanNamesForType(ChatMemory.class);
        for (String name : chatMemoryBeans) {
            Object bean = context.getBean(name);
            System.err.println("Bean Name: " + name + ", Class: " + bean.getClass().getName());
        }

        System.out.println("========== ChatMemoryStore Beans ==========");
        String[] storeBeans = beanFactory.getBeanNamesForType(ChatMemoryStore.class);
        for (String name : storeBeans) {
            Object bean = context.getBean(name);
            System.err.println("Bean Name: " + name + ", Class: " + bean.getClass().getName());
        }
        System.out.println("========== ChatModel Beans ==========");
        String[] chatModelBeans = beanFactory.getBeanNamesForType(ChatModel.class);
        for (String name : chatModelBeans) {
            Object bean = context.getBean(name);
            System.err.println("Bean Name: " + name + ", Class: " + bean.getClass().getName());
        }
    }
}
