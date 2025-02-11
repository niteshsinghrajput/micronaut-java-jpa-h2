# Use a lightweight JDK runtime
FROM eclipse-temurin:21-jre

# Set working directory inside the container
WORKDIR /app

# Copy the pre-built JAR from your local machine to the container
COPY build/libs/app.jar /app/app.jar

# Expose the application port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "/app/app.jar"]
