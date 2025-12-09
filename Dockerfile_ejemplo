# Etapa 1: construir el JAR
from rrojano/spring-boot as fuente
workdir /app 

COPY SaludarDatos/pom.xml .
RUN mvn dependency:go-offline
COPY SaludarDatos/src ./src
RUN mvn -DskipTests clean package

# Etapa 2: imagen final
FROM rrojano/spring-boot
WORKDIR /app

# Copiar el JAR generado en la etapa anterior
COPY --from=fuente /app/target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]

