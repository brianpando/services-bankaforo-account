FROM openjdk:13
VOLUME /tmp
EXPOSE 8081
ADD ./target/services-bankaforo255-account-0.0.1-SNAPSHOT.jar service-account.jar
ENTRYPOINT ["java","-jar","/service-account.jar"]