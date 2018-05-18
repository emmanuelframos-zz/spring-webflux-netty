FROM openjdk:10-jre

ENV HOME=/home/spring-webflux-netty

WORKDIR $HOME

RUN apt-get update

RUN yes | apt-get install netcat

COPY build/libs/spring-webflux-netty.jar .

COPY entrypoint.sh .

RUN chmod 755 spring-webflux-netty.jar

RUN chmod 755 entrypoint.sh