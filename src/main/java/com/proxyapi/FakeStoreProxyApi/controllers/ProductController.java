package com.proxyapi.FakeStoreProxyApi.controllers;

import com.proxyapi.FakeStoreProxyApi.dto.RequestDto;
import com.proxyapi.FakeStoreProxyApi.models.Category;
import com.proxyapi.FakeStoreProxyApi.models.Product;
import com.proxyapi.FakeStoreProxyApi.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Products")
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping
    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id){
        return productService.getSingleProduct(id);
    }

    @GetMapping("/category")
    public List<Category> getAllCategories(){

        return new ArrayList<>();
    }

    @GetMapping("/category/{categoryName}")
    public List<Product> getAllProducts(@PathVariable("categoryName") String categoryName){
        return new ArrayList<>();
    }

    @PostMapping
    public Product addProduct(@RequestBody RequestDto requestDto){
        return new Product();
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@RequestBody RequestDto requestDto, @PathVariable("id") Long id){
        return new Product();
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@RequestBody RequestDto requestDto, @PathVariable("id") Long id){
        return productService.replaceProduct(id,requestDto);
    }

}
