FROM anapsix/alpine-java:8_server-jre_unlimited
MAINTAINER yukongcode@gmail.com
VOLUME /tmp
ADD target/panda-config-server-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 6671
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]