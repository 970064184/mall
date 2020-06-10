# 微服务mall-server

# 父项目mall-parent

- >  项目中经常因为jar包冲突，出现莫名其妙的问题，所以专门抽出父项目mall-parent来管理父子项目的依赖，让所以的子项目使用的依赖都用统一的jar版本



## 主要技术点

- ```xml
  <dependencyManagement></dependencyManagement>
  ```

  - 通过<dependencyManagement>管理各种jar的版本，子项目只需要引用一个依赖不需要写版本，maven就会找到父项目中对应的jar包的版本

- ```xml
  <properties></properties>
  ```

  - 自定义maven属性，使用方式：${属性名}

## 主要依赖

- ```xml
  //springboot：2.2.2.RELEASE
  
  <java.version>11</java.version>
  <spring-cloud.version>Hoxton.SR1</spring-cloud.version>
  <redisson.version>3.12.5</redisson.version>
  ```

# 公用mall-starter

## mall-base

- > 所有项目的基础服务，主要是各种工具类


### 统一状态码

- ```java
  //CodeEnum.enum（只写有意义的状态码（其它直接写在代码里，统一状态码为500））
  ```

### 部分字典值

- ```java
  //是否可用状态枚举
  //AvailableOrNotEnum.enum
  ```


### 统一异常返回参数

- ```java
  //ErrorResp.java
  ```

### 统一业务异常

- ```java
  //BusinessException.java
  ```

- 

## mall-orm-starter

- >  mybatis 基础配置

### application-orm.yml

```yaml
mybatis-plus:
  mapper-locations: classpath:/mapper/*Mapper.xml

---
spring:
  profiles: dev
#SQL日志打印
mybatis-plus:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl

---
spring:
  profiles: test

mybatis-plus:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl

```

### 代码生成器

```java
//CodeGenerator.java
//模板：templates文件夹下
```

### 分页查询工具类

```java
//MyBaitsPageUtil.java
```

### mapper基本接口模板

```java
//mapper.xml.flt
```



## mall-web-starter

- > spring mvc 基础配置

### swagger基本配置

- ```java
  //Swagger2Config.java
  ```

- ```properties
  #swagger.enable = false #配置是否开启swagger
  ```

### 全局异常捕捉处理

- ```java
  //GlobalExceptionHandler.java
  ```

- 

### restemplate基本配置

- ```java
  //RestTemplateConfig.java
  ```

### spring mvc中文乱码解决

- ```java
  /**
   * Description: spring mvc中文乱码解决
   *
   * @author zb
   * @date 2020/5/18 18:50
   */
  public class CharsetConfig implements WebMvcConfigurer {
      @Override
      public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
          converters.add(new StringHttpMessageConverter(Charset.forName(StandardCharsets.UTF_8.name())));
      }
  
      public static void main(String[] args) {
          System.out.println(StandardCharsets.UTF_8.name());//UTF-8
      }
  }
  
  ```


### application-common.yml

```yaml
spring:
  profiles:
    active: dev
    include: common
```



### logback-base.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<configuration>
	<include resource="logback-base.xml"/>
</configuration>
```



## mall-redis-starter

- >  redis 基础配置


### redis相关的初始化配置

- ```java
  //RedisConfig.java
  ```

  - 初始化Redistemplate
  - 初始化分布式锁Redission

### 分布式锁工具类 

- ```java
  //RedissionLock.java
  ```

- 