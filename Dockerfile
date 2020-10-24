FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080/tcp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
