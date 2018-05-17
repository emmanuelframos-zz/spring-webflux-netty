FROM openjdk:8-jdk-alpine

ENV HOME=/home/spring-boot-netty

WORKDIR $HOME

ADD build/libs/spring-boot-netty.jar spring-boot-netty.jar

CMD ["java", "-jar", "spring-boot-netty.jar"]
