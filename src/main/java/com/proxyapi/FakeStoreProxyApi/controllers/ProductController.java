package com.proxyapi.FakeStoreProxyApi.controllers;

import com.proxyapi.FakeStoreProxyApi.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Products")
public class ProductController {

    @GetMapping("/")
    public List<Product> getAllProducts(){
        return new ArrayList<>();
    }


}
