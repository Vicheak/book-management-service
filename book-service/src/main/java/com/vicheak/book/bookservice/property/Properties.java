package com.vicheak.book.bookservice.property;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class Properties {

    private String message;
    private Integer buildVersion;
    private Map<String, String> messageDetails;
    private List<String> services;

}
