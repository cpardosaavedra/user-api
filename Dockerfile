FROM openjdk:17-jdk-slim

WORKDIR /app

COPY . /app/

# Copia los archivos de configuración de Gradle
RUN ./gradlew --version

CMD ./gradlew clean build bootRun -Dspring.profiles.active=dev