package com.msa.member.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SearchExceptionController {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MemberException.class)
    @ResponseBody
    public ErrorResponse invalidRequestHandler(MemberException e) {

        ErrorResponse response =  ErrorResponse.builder()
                .code("400")
                .message(e.getMessage())
                .build();
        return response;
    }
}
