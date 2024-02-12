FROM openjdk:17-jdk-alpine

MAINTAINER book-services

COPY target/configserver-1.0.0beta.jar configserver-1.0.0beta.jar

ENTRYPOINT ["java", "-jar", "/configserver-1.0.0beta.jar"]