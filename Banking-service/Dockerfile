FROM eclipse-temurin:21-jdk-alpine
LABEL maintainer="yas@code.com"
VOLUME /main-app
ADD build/libs/Banking-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
COPY wait-for-it.sh wait-for-it.sh
RUN chmod +x wait-for-it.sh

RUN apk add --no-cache bash
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=docker", "/app.jar"]

