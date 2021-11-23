FROM maven:3.8-openjdk-16-slim as maven_build

WORKDIR /usr/src/app/

# COPY pom
COPY pom.xml . 

COPY src ./src

# build the app (no dependency download here)
RUN mvn clean package  -Dmaven.test.skip


########JRE run stage########
FROM openjdk:16.0.2-jdk-slim

WORKDIR /usr/src/app


COPY --from=maven_build /usr/src/app/target/avotrack.jar ./app.jar

CMD ["java","-jar", "./app.jar"]

