package com.vicheak.book.bookservice.controller;

import com.vicheak.book.bookservice.base.BaseApi;
import com.vicheak.book.bookservice.config.BookServiceConfig;
import com.vicheak.book.bookservice.property.Properties;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/config")
@RequiredArgsConstructor
public class ConfigController {

    private final BookServiceConfig serviceConfig;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/properties")
    public BaseApi<?> loadConfigurationProperties(){
        return BaseApi.builder()
                .message("successfully loaded configuration properties from configuration service!")
                .status(true)
                .code(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .payload(Properties.builder()
                        .message(serviceConfig.getMsg())
                        .buildVersion(serviceConfig.getBuildVersion())
                        .messageDetails(serviceConfig.getMessageDetails())
                        .services(serviceConfig.getServices())
                        .build())
                .build();
    }

}
