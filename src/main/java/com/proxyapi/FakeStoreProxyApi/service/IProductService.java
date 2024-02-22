package com.proxyapi.FakeStoreProxyApi.service;

import com.proxyapi.FakeStoreProxyApi.dto.RequestDto;
import com.proxyapi.FakeStoreProxyApi.exception.ResourceNotFoundException;
import com.proxyapi.FakeStoreProxyApi.models.Category;
import com.proxyapi.FakeStoreProxyApi.models.Product;

import java.util.List;

public interface IProductService {

    public Product getSingleProduct(Long id) throws ResourceNotFoundException;

    public List<Product> getAllProducts();

    public Product replaceProduct(Long id, RequestDto requestDto);

    public Product addProduct(Product product);

    public Product updateProduct(Product product,Long id);

    public List<Category> getAllCategory();

    public String deleteProduct(Long id);
}
