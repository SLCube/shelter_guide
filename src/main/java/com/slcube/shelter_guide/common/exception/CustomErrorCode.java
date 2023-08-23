package com.slcube.shelter_guide.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum CustomErrorCode {

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 에러입니다."),

    NOT_FOUND_SHELTER_INFORMATION(HttpStatus.BAD_REQUEST, "대피소 정보를 찾을 수 없습니다.");

    private final HttpStatus httpStatus;
    private final String errorMessage;
}
