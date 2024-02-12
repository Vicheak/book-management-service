package com.vicheak.borrow.borrowservice.controller;

import com.vicheak.borrow.borrowservice.base.BaseApi;
import com.vicheak.borrow.borrowservice.config.BorrowServiceConfig;
import com.vicheak.borrow.borrowservice.property.Properties;
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

    private final BorrowServiceConfig borrowServiceConfig;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/properties")
    public BaseApi<?> loadConfigurationProperties(){
        return BaseApi.builder()
                .message("successfully loaded configuration properties from configuration service!")
                .status(true)
                .code(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .payload(Properties.builder()
                        .springDataMongodbUri(borrowServiceConfig.getSpringDataMongodbUri())
                        .management(borrowServiceConfig.getManagement())
                        .eureka(borrowServiceConfig.getEureka())
                        .info(borrowServiceConfig.getInfo())
                        .message(borrowServiceConfig.getMessage())
                        .build())
                .build();
    }

}
