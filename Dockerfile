# syntax=docker/dockerfile:1

# ===== Stage 1: build =====
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /workspace

ENV MAVEN_OPTS="-Xmx512m"

COPY pom.xml .
COPY src ./src

RUN mvn -B -ntp test
RUN mvn -B -ntp package -DskipTests

# ===== Stage 2: runtime =====
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

RUN addgroup -g 1001 -S quarkus && adduser -u 1001 -S quarkus -G quarkus

COPY --from=build --chown=1001:1001 /workspace/target/quarkus-app/lib/     ./lib/
COPY --from=build --chown=1001:1001 /workspace/target/quarkus-app/*.jar    ./
COPY --from=build --chown=1001:1001 /workspace/target/quarkus-app/app/     ./app/
COPY --from=build --chown=1001:1001 /workspace/target/quarkus-app/quarkus/ ./quarkus/

USER 1001

ENV JAVA_OPTS="-Xmx256m -Dquarkus.http.host=0.0.0.0 -Dquarkus.http.port=8080"
EXPOSE 8080

CMD ["sh", "-c", "java $JAVA_OPTS -jar quarkus-run.jar"]
