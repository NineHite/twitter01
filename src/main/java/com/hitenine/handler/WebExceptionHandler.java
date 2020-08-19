package com.hitenine.handler;

import com.hitenine.constant.ResponseCode;
import com.hitenine.exception.GlobalException;
import com.hitenine.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Hitenine
 */
@ControllerAdvice
@ResponseBody
public class WebExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(WebExceptionHandler.class);

    @ExceptionHandler(GlobalException.class)
    public ResultVO customException(GlobalException e, HttpServletRequest request) {
        if (e.getCode().equals(ResponseCode.SYSTEM_ERROR.getCode())) {
            // 400不需要持久化，将异常信息以友好的方式告知用户
            // 将500异常信息持久化处理，方便运维人员处理
            logger.error("Request URL : {}, Exception : {}", request.getRequestURL(), e);
        }
        return ResultVO.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO methodArgumentHandler(HttpServletRequest request, Exception e) {
        String filMsg = null;
        logger.error("Request URL : {}, Exception : {}", request.getRequestURL(), e);

        filMsg = ((MethodArgumentNotValidException) e).getBindingResult().getFieldError().getDefaultMessage();
        return ResultVO.error(ResponseCode.PARAMETER_FAULT.getCode(), filMsg);
    }

    @ExceptionHandler(Exception.class)
    public Object exception(Exception e, HttpServletRequest request, HttpServletResponse response) {
        // 将异常信息持久化处理，方便运维人员处理
        logger.error("Request URL : {}, Exception : {}", request.getRequestURL(), e);
        for (StackTraceElement element : e.getStackTrace()) {
            logger.error(element.toString());
        }
        String header = request.getHeader("x-requested-with");
        if ("XMLHttpRequest".equals(header)) {
            return ResultVO.error(ResponseCode.OTHER_ERROR);
        }

        return ResultVO.error(ResponseCode.OTHER_ERROR);
    }

}
