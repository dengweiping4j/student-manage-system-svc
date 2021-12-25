package com.wq.handle;

import com.wq.entity.ResultBody;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
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

    /**
     * 全局异常处理
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultBody exceptionHandler(HttpServletRequest request, Exception e) {
        log.error("系统异常！原因是: {}", e.getMessage());
        e.printStackTrace();
        return ResultBody.error(e.getMessage());
    }
}
