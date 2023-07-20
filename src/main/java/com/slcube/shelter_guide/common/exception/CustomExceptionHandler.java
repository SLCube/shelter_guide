package com.slcube.shelter_guide.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = CustomException.class)
    protected ResponseEntity<CustomErrorResponse> handleCustomException(CustomException exception) {
        return CustomErrorResponse.toResponseEntity(exception.getErrorCode());
    }

    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<CustomErrorResponse> handleException(Exception exception) {
        log.error("internal server error : {}", exception.getMessage());
        return CustomErrorResponse.toResponseEntity(CustomErrorCode.INTERNAL_SERVER_ERROR);
    }
}
