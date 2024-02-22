package com.proxyapi.FakeStoreProxyApi.controllers;

import com.proxyapi.FakeStoreProxyApi.dto.RequestDto;
import com.proxyapi.FakeStoreProxyApi.exception.ResourceNotFoundException;
import com.proxyapi.FakeStoreProxyApi.models.Category;
import com.proxyapi.FakeStoreProxyApi.models.Product;
import com.proxyapi.FakeStoreProxyApi.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Products")
public class ProductController {

    @Autowired
    @Qualifier("selfProductService")
    IProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long id) throws ResourceNotFoundException {
        Product product =productService.getSingleProduct(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> allCategories=productService.getAllCategory();
        return ResponseEntity.ok(allCategories);
    }

    @GetMapping("/category/{categoryName}")
    public ResponseEntity<List<Product>> getAllProducts(@PathVariable("categoryName") String categoryName){
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody RequestDto requestDto){
        Product product=new Product();
        product.setDescription(requestDto.getDescription());
        product.setTitle(requestDto.getTitle());
        product.setPrice(requestDto.getPrice());
        product.setImageUrl(requestDto.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(requestDto.getCategory());

        Product savedProduct=productService.addProduct(product);
        return ResponseEntity.ok(new Product());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody RequestDto requestDto, @PathVariable("id") Long id){
        Product product=new Product();
        product.setDescription(requestDto.getDescription());
        product.setTitle(requestDto.getTitle());
        product.setPrice(requestDto.getPrice());
        product.setImageUrl(requestDto.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(requestDto.getCategory());

        return new ResponseEntity<>(productService.updateProduct(product,id),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> replaceProduct(@RequestBody RequestDto requestDto, @PathVariable("id") Long id){
        Product product=productService.replaceProduct(id, requestDto);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id){
        String response= productService.deleteProduct(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
