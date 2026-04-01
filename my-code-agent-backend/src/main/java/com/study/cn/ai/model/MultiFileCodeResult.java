package com.study.cn.ai.model;

import dev.langchain4j.model.output.structured.Description;
import lombok.Data;

/**
 * 多文件代码结果
 * @Author: tom
 * @CreateTime: 2026-03-19
 * @Description:
 * @Version: 1.0
 */
@Description("生成多个代码文件的结果")
@Data
public class MultiFileCodeResult {

    /**
     * HTML 代码
     */
    @Description("HTML代码")
    private String htmlCode;

    /**
     * CSS 代码
     */
    @Description("CSS代码")
    private String cssCode;

    /**
     * JS 代码
     */
    @Description("JS代码")
    private String jsCode;

    /**
     * 描述
     */
    @Description("生成代码的描述")
    private String description;
}