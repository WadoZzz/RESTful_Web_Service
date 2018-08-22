FROM gradle:4.2.1-jdk8-alpine
COPY --chown=gradle:gradle . /spring-rest/app/
WORKDIR /spring-rest/app
RUN gradle build
CMD ["java", "-jar", "build/libs/RESTful_Web_Service-0.0.1.jar"]
