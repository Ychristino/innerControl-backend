FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=build /target/innerControl-0.0.1-SNAPSHOT.jar app.jar

ENV DATASOURCE_URL=${DATASOURCE_URL}
ENV DATABASE_USERNAME=${DATABASE_USERNAME}
ENV DATABASE_PASSWORD=${DATABASE_PASSWORD}
ENV JWT_SECRET=${JWT_SECRET}
ENV JWT_EXPIRATION_TIMEOUT=${JWT_EXPIRATION_TIMEOUT}

ENTRYPOINT ["java", "-jar", "app.jar"]