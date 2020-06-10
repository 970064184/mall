package com.mall.base.exception;

import com.mall.base.constant.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * Description: 业务异常
 *
 * @author zb
 * @date 2020/5/18 22:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BusinessException extends RuntimeException{

    /**
     * 状态码
     */
    private String code;

    /**
     * 状态描述
     */
    private String desc;

    /**
     * HTTP status（系统默认异常返回500，可自定义）
     */
    private HttpStatus httpStatus;

    public BusinessException(CodeEnum codeEnum,Object...args) {
        super(String.format(codeEnum.getDesc(),args));
        this.code = codeEnum.getCode();
        this.desc = String.format(codeEnum.getDesc(),args);
    }

    public BusinessException(HttpStatus httpStatus,CodeEnum codeEnum,Object...args) {
        super(String.format(codeEnum.getDesc(),args));
        this.httpStatus = httpStatus;
        this.code = codeEnum.getCode();
        this.desc = String.format(codeEnum.getDesc(),args);
    }

    public BusinessException(String code, String desc) {
        super(desc);
        this.code = code;
        this.desc = desc;
    }

    public BusinessException(HttpStatus httpStatus,String code, String desc) {
        super(desc);
        this.httpStatus = httpStatus;
        this.code = code;
        this.desc = desc;
    }

    public BusinessException(String desc) {
        super(desc);
        this.desc = desc;
    }
    public BusinessException(HttpStatus httpStatus,String desc) {
        super(desc);
        this.httpStatus = httpStatus;
        this.desc = desc;
    }
}
