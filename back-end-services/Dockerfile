FROM eclipse-temurin:21-jdk AS build
ARG JAR_FILE=target/*.jar
COPY ./target/api-task-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT [ "java","-jar","/app.jar" ]
