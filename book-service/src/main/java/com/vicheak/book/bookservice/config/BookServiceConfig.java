package com.vicheak.book.bookservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "book")
@Data
public class BookServiceConfig {

    private String msg;
    private Integer buildVersion;
    private Map<String, String> messageDetails;
    private List<String> services;

}
