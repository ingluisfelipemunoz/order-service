FROM maven:3.9-amazoncorretto-21-al2023 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:21-slim
WORKDIR /app
COPY --from=build /app/target/order-service*.jar order-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "order-service.jar"]
