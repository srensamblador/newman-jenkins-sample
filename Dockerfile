# BUILD STAGE
FROM maven:3.8.4-openjdk-11-slim as BUILD

WORKDIR /usr/src/app

## Cache dependencies
COPY ./web-server/pom.xml .
RUN mvn dependency:resolve

## Package WAR
COPY ./web-server .
RUN mvn clean package -DskipTests

# DEPLOY STAGE
FROM tomcat:9.0-slim as DEPLOY

WORKDIR /usr/local/tomcat/
RUN rm -rf webapps/*
## Copy WAR file
COPY --from=BUILD ./usr/src/app/target/*.war ./webapps/ROOT.war

EXPOSE 8080