FROM openjdk:8-jdk-alpine

EXPOSE 8080

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} spring.jar

RUN echo "Hold on your horses. Images is getting created"

ENTRYPOINT ["java", "-jar", "spring.jar"]

MAINTAINER "mayurssoni@hotmail.com"
