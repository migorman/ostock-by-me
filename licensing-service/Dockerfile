FROM openjdk:8-jdk-alpine
LABEL maintainer="Mouni IGORMAN <mounir.igorman@gmail.com>"
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
WORKDIR /opt
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]