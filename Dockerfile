FROM openjdk:8
EXPOSE 8080
ADD target/weather-service.jar weather-service.jar
ENTRYPOINT ["java","-jar","/weather-service.jar"]