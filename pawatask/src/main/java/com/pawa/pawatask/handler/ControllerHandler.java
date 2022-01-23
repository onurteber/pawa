package com.pawa.pawatask.handler;

import com.pawa.pawatask.exception.AuthException;
import com.pawa.pawatask.exception.TaskNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<Object> taskNotFoundException(HttpServletResponse response) throws IOException {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "task not found");
        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    }

}