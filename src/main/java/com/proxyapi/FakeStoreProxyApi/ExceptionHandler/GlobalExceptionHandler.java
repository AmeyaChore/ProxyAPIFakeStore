package com.proxyapi.FakeStoreProxyApi.ExceptionHandler;

import com.proxyapi.FakeStoreProxyApi.dto.ErrorResponseDto;
import com.proxyapi.FakeStoreProxyApi.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException){
        String errorMsg=productNotFoundException.getMessage();
        ErrorResponseDto errorResponse=new ErrorResponseDto(errorMsg);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
