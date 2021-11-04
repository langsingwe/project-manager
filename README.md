### 1.  工程说明

#### 1.1 适用场景

同一套数据模型，需要开发手机端、运营管理端等几套api，存在公共的实体类，mapper接口，并且项目需求较为简单，不需要采用微服务架构

#### 1.2 技术框架

该工程整体技术框架为`springboot + mybatis-plus + mysql`，在此基础上，保留了以下配置

1. 一些必要的工具：`fastjson、hutool-all、lombok、spring-boot-starter-aop、jsoup`
2. 自定义注解 `@Log`，用于记录接口操作日志，详细见3.1的说明
3. 跨站脚本攻击过滤器 `xssFilter` 
4. 全局异常处理器 `GlobalExceptionHandle`
5. HTTP 工具类 `ServletUtils`，全局获取`request`、`session`对象

### 2. 项目结构

工程目录结构如下，对应模块的功能也标出来了，实际开发根据自己项目需要进行必要的调整

比如我在`project-admin`工程可能要引入`spring-security`，需要编写相关的配置类，这时候可以在`project-admin`这个工程目录下，单独新建一个文件夹`config`用于编写配置类

总之，觉得存在共性的，可以复用的，放在`common`模块，个性化的配置，建议在各自的模块里单独编写类进行配置

```
project-manager   --------------------------- 父工程
├── project-common  ------------------------- 公共模块
│   └── src
│       └── main
│           ├── java
│           │   └── org
│           │       └── example
│           │           ├── aop  ------------ AOP相关配置类
│           │           ├── config  --------- 配置文件
│           │           ├── mapper  --------- mapper接口
│           │           ├── entity  --------- 实体类
│           │           │   └── vo  --------- vo对象
│           │           ├── enums  ---------- 枚举类
│           │           ├── exception   ----- 自定义异常类
│           │           ├── filter  --------- 过滤器类
│           │           ├── service  -------- service
│           │           │   └── impl  ------- service实现类
│           │           └── util  ----------- 工具类
│           │               ├── http
│           │               └── obj
│           └── resources  ------------------ 资源配置
│               ├── META-INF  --------------- 配置类扫描配置
│               └── mapper  ----------------- xml文件
└── project-web  ---------------------------- 接口模块
    ├── project-admin  ---------------------- 后台管理模块
    │   └── src
    │       ├── main
    │       │   ├── java
    │       │   │   └── org
    │       │   │       └── example
    │       │   │           ├── config  ----- 个性化的配置类
    │       │   │           └── controller  - 编写接口
    │       │   └── resources  -------------- 存放配置文件，application.yml，logback.xml等
    │       └── test
    │           └── java
    └── project-mobile  --------------------- 手机端模块
        └── src
            ├── main
            │   ├── java
            │   │   └── example
            │   │       ├── config  --------- 个性化的配置类
            │   │       └── controller  ----- 编写接口
            │   └── resources  -------------- 存放配置文件，application.yml，logback.xml等
            └── test
                └── java
```

### 3. 使用说明

#### 3.1 必要的文件说明

##### org.example.aop

* `project-common`模块`org.example.aop`目录下的自定义注解`@Log`，用于记录操作日志

* 如果不需要使用，直接删掉相关的配置类

* 如果需要使用，使用工程里的`schema.sql`初始化表。注意`org.example.aop.LogAspect`的`logPointCut`方法，`@Pointcut("@annotation(org.example.aop.Log)")`的包名，需要根据实际情况进行修改

* 使用方法参考`org.example.controller.TestController`

##### org.example.exception.GlobalExceptionHandle

全局异常配置类，我这里返回的是`ResponseEntity`，您在使用的时候，可以根据自己工程里面定义的响应类，做对应的修改

##### resources/META-INF/spring.factories

<font color='red'>非常重要！！！！！</font>

`common`工程作为`jar`包被其他工程依赖，只有加到这个配置文件里面的类，才能在作为`jar`包被引入的时候，被 spring 扫描到并且实例化到容器里

#### 3.2 配置文件修改

`admin`工程和`mobile`工程下的`application.yml`，数据库配置做相应的修改，不做赘述


