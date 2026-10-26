package com.promptledger.gateway.proxy;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.promptledger.gateway.provider.UnsupportedModelException;

@RestControllerAdvice
class ProxyExceptionHandler {

    @ExceptionHandler(UnsupportedModelException.class)
    ProblemDetail handleUnsupportedModel(UnsupportedModelException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
        problem.setTitle("Unsupported model");
        return problem;
    }
}
