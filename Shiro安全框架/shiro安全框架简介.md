# Shiro安全框架简介

## 学习目标

* 认识Shiro的整体架构，各组件的概念
* Shiro认证，授权的过程
* Shiro自定义的Realm,Filter
* Shiro Session管理
* Shiro缓存管理
* Shiro集成Spring

## 什么是Shiro？

* Apache的强大灵活的开源安全框架
* 认证、授权、企业会话管理、安全加密

## Shiro与Spring Security比较

> Spring 的官网用Shiro做安全架构（手动滑稽）

1. Shiro简单灵活、Spring Serurity复杂笨重
1. Shiro不依赖与Spring、Spring Serurity不可脱离Spring
1. Shiro粒度较粗、Spring Security力度更细

## Shiro认证

1. 创建SecurityManager
1. 主体提交请求
1. SecurityManager认证
1. Authenticator认证
1. Realm验证

## Shiro授权

1. 创建SecurityManager
1. 主体授权
1. SecurityManager授权
1. Realm获取角色权限数据
1. Authorizer授权

## Shiro自定义Realm

### 内置Realm：

* IniRealm
* JdbcRealm