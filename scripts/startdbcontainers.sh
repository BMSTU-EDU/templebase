#!/bin/bash


sudo docker network create mysql-network 

sudo docker run --name dom-mysql  --net=mysql-network  -p 3306:3306  -e MYSQL_ROOT_PASSWORD=password  -v database:/var/lib/mysql   -d mysql:5.7.13 > mysql.pid

sudo docker run --name dom-mysql-admin  --net=mysql-network  -e MYSQL_ROOT_PASSWORD=password  -e PMA_HOST="dom-mysql" -e PMA_PORT=3306  -p 8080:80 -d phpmyadmin/phpmyadmin > phpmyadmin.pid