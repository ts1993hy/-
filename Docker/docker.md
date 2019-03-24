# Docker

## Docker历史

* 2010 dotCloud PAAS
* 2013 docker开源
* 2014.6 Docker 1.0
* 2014.7 C轮 $4000万
* 2015.4 D轮 $9500万

## 什么是Docker？

  Docker是一个用来装应用的容器。

  Docker is the world's leading software containerization platform

  Docker公司开发，开源，托管到github

  跨平台，支持Windows、Macos、Linux

## 理解Docker

* 集装箱
* 标准化
  * 运输方式
  * 存储方式
  * API接口
* 隔离

## Docker解决了什么问题

* 我本地运行没问题啊！
* 系统好卡，哪个哥们又写死循环了？！
* 双11来了，服务器撑不住啦！

## 走进Docker

* 镜像
* 仓库
* 容器

### Docker镜像

  镜像就是一系列的文件，镜像的存储利用了Linux的联合文件系统的思想，进行了分层。

  分为了数层：
  1. 最底层是系统的引导
  1. 在他的上面是系统镜像层
  1. 在上面是相关的软件、如tomcat、jdk等
  1. 再上面是容器

### Docker容器

  容器的本质就是一个进程

### Docker仓库

* hub.docker.com
* c.163.com

### 拉取到启动一个docker实例（四步）

>以hello-world为例

1. Docker client连接了Docker daemon
1. Docker daemon从Docker Hub拉取了镜像
1. Docker daemon创建了一个容器用以运行可执行文件
1. Docker daemon通过输出流把信息发送到Docker client，然后Dockers client把信息发送到用户的终端

### Docker运行Nginx

#### 实验前奏

* 持久运行的容器
* 前台挂起&后台运行
* 进入容器内部

#### 实验进行中

docker run -d --detach 在后台运行一个进程并且打印进程id

#### Docker网络

* 网络类型
  * Bridge
  * Host
  * None
* 端口映射
  docker run -d -p 8080:80 ***/nginx

### Java Web应用

#### 制作自己的镜像

* Dockerfile
* docker build
* Jpress: http://jpress.io/

##### Dockerfile

```Dockerfile

from hub.c.163.com/library/tomcat

MAINTAINER tengsen XXX@163.com

COPY project.war /usr/localtomcat/webapps

```

##### docker build

> -t表示添加名字和版本

`docker build .`

`docker build -t project:latest`

## 内容回顾

* 集装箱，标准化，隔离
* 镜像，容器，仓库（BUILD，SHIP，RUN）
* docker命令pull，build，run，stop，restart，exec