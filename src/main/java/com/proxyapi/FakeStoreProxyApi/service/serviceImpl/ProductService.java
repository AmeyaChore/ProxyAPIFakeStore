package com.proxyapi.FakeStoreProxyApi.service.serviceImpl;

import com.proxyapi.FakeStoreProxyApi.dto.RequestDto;
import com.proxyapi.FakeStoreProxyApi.dto.ResponseDto;
import com.proxyapi.FakeStoreProxyApi.exception.ResourceNotFoundException;
import com.proxyapi.FakeStoreProxyApi.models.Category;
import com.proxyapi.FakeStoreProxyApi.models.Product;
import com.proxyapi.FakeStoreProxyApi.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
@Qualifier("productService")
public class ProductService implements IProductService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Product getSingleProduct(Long id) throws ResourceNotFoundException {
        ResponseDto responseDto= restTemplate
                .getForObject("https://fakestoreapi.com/products/"+id, ResponseDto.class);
        if(responseDto==null){
            throw new ResourceNotFoundException("Product with id:-"+id+" not found");
        }
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

    @Override
    public Product replaceProduct(Long id, RequestDto requestDto) {
        String url="https://fakestoreapi.com/products/"+id;
        RequestCallback requestCallback = restTemplate.httpEntityCallback(requestDto,ResponseDto.class);
        HttpMessageConverterExtractor<ResponseDto> responseExtractor =
                new HttpMessageConverterExtractor<>(ResponseDto.class, restTemplate.getMessageConverters());
        ResponseDto responseDto= restTemplate.execute(url, HttpMethod.POST, requestCallback, responseExtractor);
        return responseDtoToProduct(responseDto);
    }

    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Product product, Long id) {
        return null;
    }

    @Override
    public List<Category> getAllCategory() {
        return null;
    }

    @Override
    public String deleteProduct(Long id) {
        return null;
    }

    public Product responseDtoToProduct(ResponseDto responseDto){
        Product product=new Product();
        product.setTitle(responseDto.getTitle());
        product.setDescription(responseDto.getDescription());
        product.setPrice(responseDto.getPrice());
        product.setImageUrl(responseDto.getImage());
        return product;
    }
}
