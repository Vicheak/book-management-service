package com.vicheak.borrow.borrowservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "borrow")
@Data
public class BorrowServiceConfig {

    private String springDataMongodbUri;
    private Map<String, String> management;
    private Map<String, String> eureka;
    private Map<String, String> info;
    private String message;

}
