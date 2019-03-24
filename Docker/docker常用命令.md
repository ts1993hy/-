# Docker常用命令

`docker ps`

打印出正在运行中的docker容器

`docker ps -a`

打印出所有的docker容器

`docker images`

列出所有docker镜像（包括子镜像）

`docker run -p 80:80 -v /opt/nginx/www:/www -v /opt/nginx/conf/nginx.conf:/etc/nginx/nginx.conf -v
/opt/nginx/logs:/wwwlogs -v /root/view:/root/view --name my_nginx -d nginx:latest`

* `-v` 挂载本地文件到nginx容器中
* `-d` 后台启动这个容器
* `--name` 指定容器的名称
* `-p` 将端口映射到系统内部

产生一个docker容器（关闭的容器可以通过docker start XXX启动）

`docker rm`

删除一个容器

`docker rmi`

删除一个镜像（删除镜像时不能有该镜像的容器，无论这个容器是启动还是关闭）

`docker stop`

关闭一个容器

`docker network create app`

创建一个桥接网络，命名为app

