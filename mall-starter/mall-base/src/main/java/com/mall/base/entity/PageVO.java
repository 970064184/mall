package com.mall.base.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Description:
 *
 * @author zb
 * @date 2020/5/21 21:03
 */
@ApiModel("基本页码管理")
@Data
public class PageVO {

    @ApiModelProperty("当前页码")
    private Integer page = 1;

    @ApiModelProperty("每页记录数量")
    private Integer pageSize = 10;
}
