# Docker下安装yapi

1. docker pull silsuer/yapi (拉取yapi镜像)
1. docker run --name yapi -dit -p 27017:27017 -p 9090:9090 -p 3000:3000 silsuer/yapi (通过镜像启动一个容器，并给容器命名以及端口映射)
1. docker exec -it yapi exec bash (进入容器内部，以便启动mongodb，以及yapi进程)

## 第一次进入容器

命令行输入 yapi server，以进行一些初始化操作，此时需要在浏览器上输入 ip:9000

## 启动mongodb

service mongodb start

## 启动yapi应用程序
nohup node /my-yapi/vendors/server/app.js 2>&1 &
  
>最后退出镜像完事
