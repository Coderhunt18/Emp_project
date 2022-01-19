# Build
FROM maven:3.6.3-openjdk-8 AS build
COPY src /usr/src/app/src  
COPY pom.xml /usr/src/app  
RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests

# Deploy
FROM openjdk:8-jre-alpine
COPY --from=build /usr/src/app/target/demo-0.1.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
