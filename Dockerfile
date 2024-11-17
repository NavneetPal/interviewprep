FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/interviewprep.jar interviewprep.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","interviewprep.jar"]
