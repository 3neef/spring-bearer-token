package com.spring.jwt.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class BasicResponse {
    private String message;
    private String statusCode;
    private Object data;
}
