package org.huuloc.departmentservice.exception.advice;

import org.huuloc.departmentservice.exception.BadRequestException;
import org.huuloc.departmentservice.exception.ErrorMessage;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@ResponseBody
public class CustomAdviceController extends ResponseEntityExceptionHandler {

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<Object> handle(BadRequestException e) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .code(e.getCode())
                .message(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .description(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.badRequest().body(errorMessage);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handle(Exception e) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .message(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .description(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.internalServerError().body(errorMessage);
    }
}
