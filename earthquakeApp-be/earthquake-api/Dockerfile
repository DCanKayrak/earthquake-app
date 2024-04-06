FROM openjdk:17-jdk-slim as build
WORKDIR /earthquake-api
COPY . .
RUN ./mvnw -DskipTests clean package

FROM openjdk:17-jdk-slim
WORKDIR /earthquake-api
COPY --from=build /earthquake-api/target/*.jar ./earthquake-api.jar

ENV SPRING_PROFILES_ACTIVE=dev

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}", "earthquake-api.jar"]