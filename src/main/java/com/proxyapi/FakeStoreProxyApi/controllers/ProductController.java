package com.proxyapi.FakeStoreProxyApi.controllers;

import com.proxyapi.FakeStoreProxyApi.dto.RequestDto;
import com.proxyapi.FakeStoreProxyApi.exception.ProductNotFoundException;
import com.proxyapi.FakeStoreProxyApi.models.Category;
import com.proxyapi.FakeStoreProxyApi.models.Product;
import com.proxyapi.FakeStoreProxyApi.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
        Product product =productService.getSingleProduct(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAllCategories(){

        return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping("/category/{categoryName}")
    public ResponseEntity<List<Product>> getAllProducts(@PathVariable("categoryName") String categoryName){
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody RequestDto requestDto){
        return ResponseEntity.ok(new Product());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody RequestDto requestDto, @PathVariable("id") Long id){
        return new ResponseEntity<>(new Product(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> replaceProduct(@RequestBody RequestDto requestDto, @PathVariable("id") Long id){
        Product product=productService.replaceProduct(id, requestDto);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

}
