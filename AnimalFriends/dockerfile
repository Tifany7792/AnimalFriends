FROM maven:3.3-jdk-8 as builder
COPY . /code/
WORKDIR /code
RUN mvn package -DskipTests=true

FROM openjdk:8-jre
COPY --from=builder /code/target/*.jar /usr/app/
WORKDIR /usr/app
CMD [ "java", "-jar", "app.jar" ]