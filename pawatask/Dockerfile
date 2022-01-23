FROM openjdk:8-jdk-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} pawatask-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/pawatask-0.0.1-SNAPSHOT.jar"]