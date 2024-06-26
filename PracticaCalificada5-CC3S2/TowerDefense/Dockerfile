# estamos utilizando openjdk17, por lo que buscaremos su versión light
FROM openjdk:17-slim as build
WORKDIR /app
# Solo copiamos los archivos necesarios: gradles(configuraciones) y src(proyecto). evitamos las configuraciones propias del IDEA-PROYECT
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
# permisos gradle
RUN chmod +x ./gradlew
RUN ./gradlew build
# Inicia una nueva etapa desde cero para solo mantener ejecutable RUN
FROM openjdk:17-slim
WORKDIR /app
# lo volvemos ejecutable el proyecto
COPY --from=build /app/build/libs/*.jar ./app.jar
CMD ["java", "-jar", "app.jar"]
