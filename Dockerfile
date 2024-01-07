#Build an excutable jar
FROM gradle:8.5.0-jdk21 AS build
WORKDIR /home/app
COPY . /home/app

RUN gradle clean build

# Build an image
FROM jyckbase/java21
MAINTAINER himanshu2703@gmail.com
EXPOSE 8080

RUN mkdir target

ARG JAR_FILE=build/libs/dockspring-0.0.1-SNAPSHOT.jar
COPY  ${JAR_FILE} target/dockspring.jar

ENTRYPOINT ["java","-jar","target/dockspring.jar"]