FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

# Yerel makinedeki doğru dizinden JAR dosyasını kopyala
COPY /build/libs/devopssssss-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
