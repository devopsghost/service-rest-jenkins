FROM eclipse-temurin:17
RUN mkdir /app
COPY /target/service-rest-jenkins-2.0.0.jar /app
CMD ["java", "-jar", "/app/service-rest-jenkins-2.0.0.jar"]