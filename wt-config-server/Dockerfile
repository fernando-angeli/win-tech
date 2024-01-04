FROM openjdk:11
VOLUME /tmp
EXPOSE 8888
ADD ./target/wt-config-server-0.0.1-SNAPSHOT.jar wt-config-server.jar
ENTRYPOINT ["java","-jar","/wt-config-server.jar"]
