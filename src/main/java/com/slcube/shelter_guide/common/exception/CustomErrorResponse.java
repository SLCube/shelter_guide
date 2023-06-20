package com.slcube.shelter_guide.common.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Getter
public class CustomErrorResponse {

    private final LocalDateTime timestamp;
    private final int status;
    private final String error;
    private final CustomErrorCode errorCode;
    private final String message;

    public static ResponseEntity<CustomErrorResponse> toResponseEntity(CustomErrorCode errorCode) {
        return ResponseEntity
                .status(errorCode.getHttpStatus().value())
                .body(CustomErrorResponse.builder()
                        .status(errorCode.getHttpStatus().value())
                        .error(errorCode.getHttpStatus().name())
                        .customErrorCode(errorCode)
                        .message(errorCode.getErrorMessage())
                        .build());

    }

    @Builder
    private CustomErrorResponse(int status, String error, CustomErrorCode customErrorCode, String message) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.errorCode = customErrorCode;
        this.message = message;
    }
}
