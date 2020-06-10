package com.mall.test.brand.controller;


import com.mall.test.brand.entity.TbBrand;
import com.mall.test.brand.service.ITbBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;



/**
 * <p>
 * 品牌表 前端控制器
 * </p>
 *
 * @author zb
 * @since 2020-05-21
 */
 @Api(tags="品牌表相关接口")
@RestController
@RequestMapping("/brand")
public class TbBrandController {

     @Autowired
     private ITbBrandService service;

     @ApiOperation(value = "根据 ID 查询", notes = "根据 主键ID 查询")
     @PostMapping(value = "/getById")
     public  TbBrand getById(@RequestParam("id")Serializable id) {
        TbBrand respData = service.getById(id);
        return respData;
     }

    @ApiOperation(value = "新增记录", notes = "插入一条记录")
    @PostMapping(value = "/save")
    public  Boolean save(@RequestBody TbBrand entity) {
        boolean respData = service.save(entity);
        return respData;
    }

     @ApiOperation(value = "根据 ID 删除", notes = "根据 ID 删除")
     @PostMapping(value = "/removeById")
     public  Boolean removeById(@RequestParam("id")Serializable id) {
        boolean respData = service.removeById(id);
        return respData;
     }

     @ApiOperation(value = "根据 ID 选择修改", notes = "根据 ID 选择修改")
     @PostMapping(value = "/updateById")
     public  Boolean updateById(@RequestBody TbBrand entity) {
        boolean respData = service.updateById(entity);
        return respData;
     }



 }
