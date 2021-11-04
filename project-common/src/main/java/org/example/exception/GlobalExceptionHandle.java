package org.example.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandle {

    @ExceptionHandler(Exception.class)
    public ResponseEntity ExceptionHandler(Exception e) {
        log.error("错误异常为：" + e.getMessage(), e);
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
