FROM 193.112.100.103:5000/java:8
VOLUME /tmp
ADD target/panda-config-server-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]