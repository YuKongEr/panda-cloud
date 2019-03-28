
[![](https://img.shields.io/github/license/mashape/apistatus.svg)](https://github.com/YuKongEr/panda)
[![](https://img.shields.io/badge/release-v1.0-brightgreen.svg
)](https://github.com/YuKongEr/panda)
[![](https://img.shields.io/badge/springboot-%3E%3D2.0-blue.svg
)](https://github.com/YuKongEr/panda)
[![](https://img.shields.io/badge/springcloud-Finchley.SR1-blue.svg
)](https://github.com/YuKongEr/panda)

> 2019年01月23日13:47:44 更新
大家clone项目之后 需要把每个服务的bootstrap.yml中的配置改了 不然现在的注册是我公网的
193的服务器，大家都注册到同一个注册中心，服务调用的时候根据负载均衡，会出现一些服务不可用的情况
另外 如果有想一起开发的 请加Q群 558509374 联系我，期待你的加入

- 代码生成：提供灵活模板设置，减少重复工作
- 全面登录：手机验证码登录，用户名密码登录
- 动态路由: 基于zuul配置，提供ui界面配置
- 操作日志：记录登录日志，操作日志，异常日志，采用自己定义注解`@SysLog`即可
- 消息总线：使用spring bus提供配置动态刷新
- 接口文档：zuul聚合swagger 提供api文档
- 消息中心：集成阿里云 腾讯云 钉钉，提供接口发送短信、邮件

## 技术选型&文档

- Spring Boot（[查看Spring Boot学习&使用指南](https://www.jianshu.com/p/0d400d30936b)）
- Spring Cloud（[查看官方中文文档](https://springcloud.cc/spring-cloud-dalston.html)）

- Spring Security Oauth2（[查看官方中文文档](http://projects.spring.io/spring-security-oauth/docs/oauth2.html)）

- MyBatis（[查看官方中文文档](http://www.mybatis.org/mybatis-3/zh/index.html)）

- MyBatis plus（[查看官方中文文档](http://mp.baomidou.com/)）

- Vue.js（[查看官方中文文档](https://cn.vuejs.org/)）

- ElementUI（[查看官方中文文档](http://element.eleme.io/#/)）

- Redis

- RabbitMq

- OSS


## 介绍

- panda-server 服务注册中心
- panda-auth  oauth2 认证服务器 提供token
- panda-common 公共模块集合
- panda-config-server 配置中心服务器
- panda-gateway 统一网关，提供动态路由 同时也是oauth2的资源服务器
- panda-service 业务模块集合
  - panda-user-service 统一用户管理模块
  - panda-gen-service 代码生成器模块
    

后续会陆续支持 zipkin服务链路监控  springboot-admin 服务健康监控等
## 进度

![index](https://github.com/YuKongEr/panda/blob/master/imgs/index.png)

![resource-1](https://github.com/YuKongEr/panda/blob/master/imgs/resource-1.png)

![resource-2](https://github.com/YuKongEr/panda/blob/master/imgs/resource-2.png)

![role](https://github.com/YuKongEr/panda/blob/master/imgs/role.png)

![login-log](https://github.com/YuKongEr/panda/blob/master/imgs/login-log.png)

![operator-log](https://github.com/YuKongEr/panda/blob/master/imgs/operator-log.png)

![exception-log-1](https://github.com/YuKongEr/panda/blob/master/imgs/exception-log-1.png)

![exception-log-2](https://github.com/YuKongEr/panda/blob/master/imgs/exception-log-2.png)

![gen](https://github.com/YuKongEr/panda/blob/master/imgs/code.png)

- [x] 登录管理
  - [x] 登录
  - [x] 登出
- [x] 系统管理
  - [x] 资源管理
    - [x] 查看资源
    - [x] 添加资源
    - [x] 修改资源
    - [x] 删除资源
  - [x] 角色管理
    - [x] 查看角色
    - [x] 添加角色
    - [x] 修改角色
    - [x] 分配资源
  - [x] 用户管理
    - [x] 查看用户
    - [x] 添加用户
    - [x] 修改用户
    - [x] 分配角色
  - [ ] 字典管理
  - [ ] 终端管理
  - [ ] 令牌管理
- [x] 日志管理
    - [x] 登录日志
       - [x] 查询日志
    - [x] 操作日志
       - [x] 查询日志
    - [x] 异常日志
       - [x] 查询日志
- [x] 研发管理
  - [x] 代码生成
    - [x] 查询表格
    - [x] 生成代码
  - [x] 接口文档
- [ ] 个人中心
  - [ ] 查看资料
  - [ ] 修改资料




 ## 启动教程

 - 根据`init.sql` 创建数据库
 - 首先启动 `panda-server` 注册中心
 - 然后启动`panda-config-server`配置注册中心
 - 启动统一用户服务`panda-user-service`
 - 启动认证服务`panda-auth`  以为认证服务依赖于统一用户服务，所以 统一用户服务器启动在前
 - 最后启动`panda-gateway` 网关
 - 然后启动前台工程  `npm run dev / yarn run dev`就可以

[panda-admin前台工程地址](https://github.com/YuKongEr/panda-admin)



目前完成 基础权限模块，接下来会完善动态路由界面可视化配置，与个人中心模块。