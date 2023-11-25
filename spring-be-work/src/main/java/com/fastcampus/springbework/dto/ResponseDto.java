package com.fastcampus.springbework.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ResponseDto {

    private String response;
    private String message;
    private Object data;

    @Builder
    public ResponseDto (String response, String message, Object object) {
        this.response = response;
        this.message = message;
        this.data = object;
    }
}
