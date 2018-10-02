#!/bin/bash

mysql=`cat mysql.pid`
phpmyadmin=`cat phpmyadmin.pid`

sudo docker rm $mysql
sudo docker rm $phpmyadmin

sudo docker network remove mysql-network 

rm mysql.pid
rm phpmyadmin.pid