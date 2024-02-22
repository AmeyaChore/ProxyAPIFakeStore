package com.proxyapi.FakeStoreProxyApi.ExceptionHandler;

import com.proxyapi.FakeStoreProxyApi.dto.ErrorResponseDto;
import com.proxyapi.FakeStoreProxyApi.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleProductNotFoundException(ResourceNotFoundException resourceNotFoundException){
        String errorMsg= resourceNotFoundException.getMessage();
        ErrorResponseDto errorResponse=new ErrorResponseDto(errorMsg);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
