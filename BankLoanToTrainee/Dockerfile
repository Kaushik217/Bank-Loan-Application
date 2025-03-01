# Use the official Maven image to build the application
FROM maven:latest AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml and the source code from the BankLoanToTrainee directory
COPY BankLoanToTrainee/pom.xml .
COPY BankLoanToTrainee/src ./src

# Build the application
RUN mvn clean package

# Use a smaller image for the final application
FROM openjdk:23-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built jar file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Specify the command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]