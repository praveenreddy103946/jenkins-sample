FROM eclipse-temurin:17-jdk-alpine
EXPOSE 9090
ADD target/jenkins-sample.jar jenkins-sample.jar
ENTRYPOINT [ "java","-jar","/jenkins-sample.jar" ]