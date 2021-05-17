FROM openjdk:11-jdk
EXPOSE 8081
ADD target/ebuygds.jar  ebuygds.jar
ENTRYPOINT ["java","-jar", "/ebuygds.jar"]