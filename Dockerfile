FROM openjdk:8-jre-alpine

EXPOSE 8080

COPY ./target/basic-java-app-*.jar /usr/app/
WORKDIR /usr/app

CMD java -jar basic-java-app-*.jar
