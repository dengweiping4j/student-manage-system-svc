package com.wq.handle;

import com.wq.entity.ResultBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常拦截
 *
 * @author 邓卫平
 * @date 2021/12/18 11:38
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ResultBody BindExceptionHandler(HttpServletRequest request, MethodArgumentNotValidException e) {
        log.error("数据不合法：{}", e.getMessage());
        e.printStackTrace();
        return ResultBody.error(e.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    @ResponseBody
    public ResultBody IllegalArgumentExceptionHandler(HttpServletRequest request, MethodArgumentNotValidException e) {
        log.error("不合法的参数：{}", e.getMessage());
        e.printStackTrace();
        return ResultBody.error(e.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultBody exceptionHandler(HttpServletRequest request, Exception e) {
        log.error("系统异常！原因是: {}", e.getMessage());
        e.printStackTrace();
        return ResultBody.error(e.getMessage());
    }
}
