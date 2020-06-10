package com.mall.base.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Description:
 *
 * @author zb
 * @date 2020/5/21 21:14
 */
@ApiModel("分页查询结果")
@Data
public class PageResult<T> {

    @ApiModelProperty("总记录数")
    private Long total;

    @ApiModelProperty("总页码")
    private Integer totalPage;

    @ApiModelProperty("数据")
    private List<T> data;
}
