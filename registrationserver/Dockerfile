FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
ADD ./build/libs/registrationserver-0.0.1-SNAPSHOT.jar app.jar

# Install wait-for (https://github.com/Eficode/wait-for)
COPY wait-for /wait-for
RUN chmod +x /wait-for

ENTRYPOINT ["/wait-for", "config:8888", "--", "java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

EXPOSE 8000
