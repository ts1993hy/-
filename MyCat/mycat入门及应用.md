# MyCat入门及应用

## 学习目的

* 掌握再数据库负载增大时的处理方法
* 理解MyCat的基础概念
* 掌握MyCat的基础配置和监控方法

## MyCat的前世今生

Amoeba —— 2008年
Cobar —— 2012年
MyCat诞生 —— 2013年（问题很大）
MyCat1.6 —— 2017年

## MyCat的主要作用

* 实现数据库的读写分离
* MyCat支持读负载均衡
* MyCat支持后端MySQL高可用
* 数据库的垂直拆分
* 数据库水平拆分

## MyCat的应用场景

* 需要进行读写分离的场景
* 需要进行分库分表的场景
* 多租户场景
* 数据统计系统
* HBASE的一种替代方案
* 需要使用同样的方式查询多种数据库的场景

## MyCat的优势

* 基于Cobar系统开发
* 开发社区活跃
* 完全开源可以自定义开发
* 支持多种关系型及NOSQL数据库
* 使用JAVA开发，可以部署在多种系统上
* 具有在多种行业和项目中应用的成功案例

## MyCat的基本概念

* MyCat中的数据库——逻辑库
* MyCat中的数据库——逻辑表

## MyCat的关键特性

* 支持SQL92标准
* 支持MySql集群
* 支持JDBC连接数据库
* 支持NOSQL数据库
* 支持自动故障切换，高可用性
* 支持读写分离
* 支持全局表
* 支持独有的基于ER关系的分片策略
* 支持一致性HASH分片（ps:现在同一台机器上进行分片，当数据库负载过大时，可将分片迁移到其他机器的数据库中）
* 多平台支持，部署简单方便
* 全局序列号

## 安装MyCat

1. 安装Java环境
1. 下载MyCat
1. 新建MyCat用户
1. 解压MyCat
1. 配置环境变量
1. 启动MyCat

## 启动MyCat

* $MYCAT_HOME/bin/startup_nowrap.sh
* JAVA_OPTS="-server -Xms1G -Xmx2G -XX:MaxPermSize=64M -XX:+AggressiveOpts -XX:MaxDirectMemorySize=2G"

## MyCat的关键配置文件

* schema.xml用于配置逻辑库表及数据节点
* rule.xml用于配置表的分片规则
* server.xml用于配置服务器权限

### schema.xml文件

* `<schema><table></table></schema>`定义逻辑库表
* `<dataNode></dataNode>定义数据节点`
* `<dataHost></dataHost>`定义数据节点的物理数据源

### rule.xml文件

* `<tableRule name=""></tableRule>`定义表使用的分片规则
* `<function name=""></function>定义分片算法`

### server.xml文件

* `<system><property name=""></property></system>`用于定义系统配置
* `<user></user>`用于定义连接MyCat