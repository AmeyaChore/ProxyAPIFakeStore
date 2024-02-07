package com.proxyapi.FakeStoreProxyApi.service;

import com.proxyapi.FakeStoreProxyApi.dto.RequestDto;
import com.proxyapi.FakeStoreProxyApi.models.Product;

import java.util.List;

public interface IProductService {

    public Product getSingleProduct(Long id);

    public List<Product> getAllProducts();

    public Product replaceProduct(Long id, RequestDto requestDto);
}
