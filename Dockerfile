FROM openjdk:17-jdk
MAINTAINER solbeg
COPY target/classes .
ENTRYPOINT ["java","-jar","/cities-shower.jar"]