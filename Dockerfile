FROM openjdk:8
VOLUME /tmp
EXPOSE 8080
CMD java -jar build/libs/docker.rest-0.0.1.jar
ADD build/libs/docker.rest-0.0.1.jar build/libs/docker.rest-0.0.1.jar
ENTRYPOINT ["java","-jar","build/libs/docker.rest-0.0.1.jar"]



