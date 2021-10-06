FROM openjdk:8-jre-slim
COPY ./target/user-app.jar /app/
WORKDIR /app
EXPOSE 8083
CMD ["java", "-jar", "user-app.jar"]