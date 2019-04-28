FROM mysql:5.7
MAINTAINER yukong(yukongcode@gmail.com)
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
COPY ./sql/init.sql /docker-entrypoint-initdb.d