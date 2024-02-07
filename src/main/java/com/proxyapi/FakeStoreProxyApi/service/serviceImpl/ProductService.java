package com.proxyapi.FakeStoreProxyApi.service.serviceImpl;

import com.proxyapi.FakeStoreProxyApi.dto.ResponseDto;
import com.proxyapi.FakeStoreProxyApi.models.Product;
import com.proxyapi.FakeStoreProxyApi.service.IProductService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Product getSingleProduct(Long id) {
        ResponseDto responseDto= restTemplate
                .getForObject("https://fakestoreapi.com/products/"+id, ResponseDto.class);
        return responseDtoToProduct(responseDto);
    }

    @Override
    public List<Product> getAllProducts() {
        ResponseDto [] responseDtoArr= restTemplate.getForObject("https://fakestoreapi.com/products",ResponseDto[].class);

        List<Product> productList=new ArrayList<>();
        for(ResponseDto responseDto: responseDtoArr){
            productList.add(responseDtoToProduct(responseDto));
        }

        return productList;
    }

    public Product responseDtoToProduct(ResponseDto responseDto){
        Product product=new Product();
        product.setName(responseDto.getTitle());
        product.setDescription(responseDto.getDescription());
        product.setPrice(responseDto.getPrice());
        product.setImageUrl(responseDto.getImage());
        return product;
    }
}
