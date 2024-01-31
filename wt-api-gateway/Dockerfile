FROM openjdk:21
VOLUME /tmp
EXPOSE 8765
ADD ./target/wt-api-gateway-0.0.1-SNAPSHOT.jar wt-api-gateway.jar
ENTRYPOINT ["java","-jar","/wt-api-gateway.jar"]
