# Dockerfile for board-api (Spring Boot backend)
FROM eclipse-temurin:21-jre-alpine as builder
WORKDIR /app
COPY board-api/pom.xml .
COPY board-api/mvnw .
COPY board-api/.mvn .mvn
RUN ./mvnw dependency:go-offline
COPY board-api/src ./src
RUN ./mvnw package -DskipTests

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/board-api-*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
