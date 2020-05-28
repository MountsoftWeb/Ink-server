package com.ink.server.web.excption;

import com.ink.server.common.utils.response.ApiResponse;
import com.ink.server.common.utils.response.ApiResponseEnum;
import com.ink.server.common.utils.response.RetResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Created by carlos
 */
@ControllerAdvice
public class MyExceptionHandler {
    Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseBody
    public ApiResponse exceptionHandle(MissingServletRequestParameterException e) {
        logger.error("空指针异常");
        return RetResponse.ofMessage(ApiResponseEnum.ERROR);
    }
}
