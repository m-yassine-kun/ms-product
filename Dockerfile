FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/ms-product*.jar /app-ms-product.jar
CMD ["java","-jar","/app-ms-product.jar","--spring.profiles.active=prod"]
EXPOSE 8081