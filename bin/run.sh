#!/bin/sh
./gradlew clean build

cp build/libs/spring-boot-netty.jar .

docker stop $(docker ps -qa --filter="name=spring-boot-netty") || true

docker rm -f $(docker ps -qa --filter="name=spring-boot-netty") || true

docker build -t spring-boot-netty:latest .

docker run -d -p 8080:8080 --name spring-boot-netty -t spring-boot-netty:latest