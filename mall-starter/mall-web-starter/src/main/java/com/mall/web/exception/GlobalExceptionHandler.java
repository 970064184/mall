package com.mall.web.exception;

import com.mall.base.constant.CodeEnum;
import com.mall.base.model.ErrorResp;
import com.mall.base.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

/**
 * Description: 全局异常处理
 *
 * @author zb
 * @date 2020/5/18 22:44
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 业务异常 可通过HTTP status && 枚举的状态值判断
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public ErrorResp businessException(BusinessException e, HttpServletResponse response){
        log.error("微服务业务异常",e);
        if(null == e.getHttpStatus()){//默认返回500状态码
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }else{
            response.setStatus(e.getHttpStatus().value());
        }
        String code = StringUtils.isEmpty(e.getCode())? CodeEnum.ERROR.getCode():e.getCode();
        String desc = StringUtils.isEmpty( e.getDesc())? CodeEnum.ERROR.getDesc():e.getDesc();
        ErrorResp errorResp = new ErrorResp(code, desc);
        return errorResp;
    }
}
