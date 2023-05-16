
FROM amazoncorretto:17-alpine3.17-jdk

MAINTAINER FireDust97

COPY target/backend-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

entrypoint ["java","-jar","/app.jar"]