FROM sgrio/java:jdk_11
MAINTAINER Voufack Harold (haroldvoufack@gmail.com)
COPY /target/source-0.0.1-SNAPSHOT.jar /usr/local/service/target/source.jar
WORKDIR /usr/local/service
ENTRYPOINT ["java","-jar","target/source.jar"]