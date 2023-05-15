FROM openjdk:17-jdk

WORKDIR /app

COPY ./target/my-spring-boot-app.jar /app/backend-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "my-spring-boot-app.jar"]

EXPOSE 8080