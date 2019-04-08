# mysql

docker run -p 3306:3306 --name mymysql -v /opt/mysql/conf:/etc/mysql/conf.d -v /opt/mysql/logs:/logs -v /opt/mysql/data:/var/lib/mysql -v /etc/localtime:/etc/localtime:ro -e MYSQL_ROOT_PASSWORD=lxtilyvm123 -d mysql:latest