package com.study.cn.model.dto.app;

import lombok.Data;

import java.io.Serializable;

/**
 * 应用部署请求
 * @Author: tom
 * @CreateTime: 2026-03-19
 * @Description:
 * @Version: 1.0
 */
@Data
public class AppDeployRequest implements Serializable {

    /**
     * 应用 id
     */
    private Long appId;

    private static final long serialVersionUID = 1L;
}