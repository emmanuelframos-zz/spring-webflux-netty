#!/bin/sh
while ! nc -z mongo 27017 ; do
    echo "Waiting for Mongo"
    sleep 2
done
java -jar spring-webflux-netty.jar