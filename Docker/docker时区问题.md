# docker时区问题

1. 重新启动容器（docker run，挂载时区文件）

-v /etc/localtime:/etc/localtime:ro

1. 把文件复制到容器内

docker cp /etc/localtime [containerId]:/etc/localtime

