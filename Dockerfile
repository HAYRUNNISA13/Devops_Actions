# Temel imaj (OpenJDK 17 kullanıyoruz)
FROM eclipse-temurin:17-jdk-jammy

# Çalışma dizini oluştur
WORKDIR /app

# JAR dosyasını kopyala (Gradle varsayılan build dizini)
COPY build/libs/*.jar app.jar

# Uygulama portunu aç (Spring Boot varsayılanı 8080)
EXPOSE 8080

# Uygulamayı çalıştır
ENTRYPOINT ["java", "-jar", "app.jar"]