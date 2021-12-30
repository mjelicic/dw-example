FROM openjdk:17

RUN mkdir -p /srv/app
COPY target/dwexample-1.0-SNAPSHOT.jar /srv/app
COPY config.yml /srv/app
WORKDIR /srv/app

EXPOSE 8080 8081
CMD ["java", "-jar", "dwexample-1.0-SNAPSHOT.jar", "server", "config.yml"]
