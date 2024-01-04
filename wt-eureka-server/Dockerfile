FROM openjdk:21
VOLUME /tmp
EXPOSE 8761
ADD ./target/wt-eureka-server-0.0.1-SNAPSHOT.jar wt-eureka-server.jar
ENTRYPOINT ["java","-jar","/wt-eureka-server.jar"]