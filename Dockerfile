FROM ubuntu:latest AS build
RUN apt-get update
RUN apt-get install openjdk-21-jdk -y
RUN apt-get update && apt-get install dos2unix -y
COPY . .

RUN dos2unix ./mvnw
RUN chmod +x ./mvnw
RUN ./mvnw clean install -U
EXPOSE 8080
ENTRYPOINT ["./mvnw", "spring-boot:run"]