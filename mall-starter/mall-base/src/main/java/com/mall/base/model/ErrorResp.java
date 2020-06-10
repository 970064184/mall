package com.mall.base.model;

import com.mall.base.constant.CodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:
 *
 * @author zb
 * @date 2020/5/18 22:39
 */
@ApiModel("异常返回参数")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResp {

    @ApiModelProperty("业务异常状态码")
    private String code;
    @ApiModelProperty("业务异常描述")
    private String errorMsg;

    /**
     * 常用构造器
     * @param codeEnum 统一状态码
     */
    public ErrorResp(CodeEnum codeEnum) {
        this.code = codeEnum.getCode();
        this.errorMsg = codeEnum.getDesc();
    }


}
