FROM anapsix/alpine-java:8_server-jre_unlimited
MAINTAINER yukongcode@gmail.com
VOLUME /tmp
ADD target/panda-zipkin-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 5001
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]