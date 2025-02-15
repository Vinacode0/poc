FROM openjdk:17-jdk
EXPOSE 8081
COPY target/test.jar test.jar
ENTRYPOINT [ "java","-jar","test.jar" ]