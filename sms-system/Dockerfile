FROM maven:3.9-eclipse-temurin-26 AS build

WORKDIR /app
COPY sms-system/pom.xml .
RUN mvn dependency:go-offline -q
COPY sms-system/src ./src
RUN mvn package -DskipTests -q

FROM eclipse-temurin:26-jre

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
