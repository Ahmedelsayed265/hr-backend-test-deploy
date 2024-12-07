# First Stage: Build the application
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests && mvn clean

# Second Stage: Run the application
FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar jpa.jar
EXPOSE 8000
ENTRYPOINT ["java", "-jar", "jpa.jar"]
