package com.datawiser.exception;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Jim Han
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public String exceptionHandler(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        if(e instanceof MethodArgumentNotValidException){
            MethodArgumentNotValidException ex= (MethodArgumentNotValidException) e;
            List<ObjectError> errors = ex.getBindingResult().getAllErrors();
            ObjectError error = errors.get(0);
            String msg = error.getDefaultMessage();
            return msg;
        }else {
            return "服务器错误";
        }
    }

}
