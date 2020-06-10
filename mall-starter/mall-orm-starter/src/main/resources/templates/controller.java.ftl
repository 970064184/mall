package ${package.Controller};


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.Serializable;
import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
<#if swagger2>
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>



/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if swagger2>
 @Api(tags="${table.comment!}相关接口")
</#if>
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
<#--@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")-->
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

     @Autowired
     private ${table.serviceName} service;

     <#if swagger2>
     @ApiOperation(value = "根据 ID 查询", notes = "根据 主键ID 查询")
     <#else>
      /**
      * 根据 ID 查询
      */
     </#if>
     @PostMapping(value = "/getById")
     public  ${entity} getById(@RequestParam("id")Serializable id) {
        ${entity} respData = service.getById(id);
        return respData;
     }

    <#if swagger2>
    @ApiOperation(value = "新增记录", notes = "插入一条记录")
    <#else>
    /**
    * 插入一条记录（选择字段，策略插入）
    */
    </#if>
    @PostMapping(value = "/save")
    public  ${r'Boolean'} save(@RequestBody ${entity} entity) {
        boolean respData = service.save(entity);
        return respData;
    }

     <#if swagger2>
     @ApiOperation(value = "根据 ID 删除", notes = "根据 ID 删除")
     <#else>
      /**
      * 根据 ID 删除
      */
     </#if>
     @PostMapping(value = "/removeById")
     public  ${r'Boolean'} removeById(@RequestParam("id")Serializable id) {
        boolean respData = service.removeById(id);
        return respData;
     }

     <#if swagger2>
     @ApiOperation(value = "根据 ID 选择修改", notes = "根据 ID 选择修改")
     <#else>
      /**
      * 根据 ID 选择修改
      */
     </#if>
     @PostMapping(value = "/updateById")
     public  ${r'Boolean'} updateById(@RequestBody ${entity} entity) {
        boolean respData = service.updateById(entity);
        return respData;
     }



 }
</#if>
