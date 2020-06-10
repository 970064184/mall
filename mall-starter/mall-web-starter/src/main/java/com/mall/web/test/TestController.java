package com.mall.web.test;

import com.alibaba.fastjson.JSONObject;
import com.mall.base.constant.CodeEnum;
import com.mall.base.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author zb
 * @date 2020/5/12 18:57
 */
@RestController
@Api("测试API")
public class TestController {

    @ApiOperation(value = "hello world",notes = "测试接口返回hello world")
    @GetMapping("/helloworld")
    public String test(){
        return "hello world!";
    }

    @ApiOperation(value = "无返回值",notes = "测试接口无返回值")
    @GetMapping("/testvoid")
    public String testVoid(@RequestParam("param")String param){
        System.out.println("测试接口无返回值"+param);
        if("test".equals(param)){
            throw new BusinessException("测试业务异常");
        }else if("code".equals(param)){
            throw new BusinessException(CodeEnum.WEB_SYSTEM_EXCEPTION,"测试");
        }else if("msg".equals(param)){
            throw new BusinessException("2020","520");
        } else if ("httpstatus".equals(param)) {
            throw new BusinessException(HttpStatus.OK,"测试HTTPstatus的修改");
        }
        return param;
    }

    @ApiOperation(value = "所有代码值",notes = "测试返回所有代码值")
    @GetMapping("/getallcodes")
    public JSONObject getAllCodes(){
        JSONObject jsonObject = new JSONObject();
        for (CodeEnum codeEnum : CodeEnum.values()) {
            jsonObject.put(codeEnum.getCode(),codeEnum.getDesc());
        }
        return jsonObject;
    }


}
