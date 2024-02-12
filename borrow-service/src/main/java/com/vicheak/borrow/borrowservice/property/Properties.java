package com.vicheak.borrow.borrowservice.property;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class Properties {

    private String springDataMongodbUri;
    private Map<String, String> management;
    private Map<String, String> eureka;
    private Map<String, String> info;
    private String message;

}
