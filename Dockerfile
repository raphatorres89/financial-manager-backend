FROM openjdk:8-jdk-alpine
MAINTAINER Raphael Carvalho Torres
COPY /build/libs/financial-manager-0.0.1-SNAPSHOT.jar /var/www/financial-manager-0.0.1-SNAPSHOT.jar
WORKDIR /var/www
ENTRYPOINT java -jar financial-manager-0.0.1-SNAPSHOT.jar
EXPOSE 8080