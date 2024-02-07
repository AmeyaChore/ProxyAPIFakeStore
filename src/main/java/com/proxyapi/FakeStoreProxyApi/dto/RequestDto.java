package com.proxyapi.FakeStoreProxyApi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDto {

    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
}
