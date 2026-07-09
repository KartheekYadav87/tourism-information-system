FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/*.jar tourism.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","tourism.jar"]