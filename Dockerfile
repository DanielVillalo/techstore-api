FROM eclipse-temurin:17-jre
WORKDIR /app
COPY target/api-0.0.1-SNAPSHOT.jar app.jar
COPY src/main/resources/wallet /app/wallet
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]