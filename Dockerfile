FROM alpine:3.14
RUN apk add --no-cache openjdk11
COPY build/libs/docker-common-0.0.1-SNAPSHOT.jar /app/
WORKDIR /app
ENTRYPOINT ["java"]
CMD ["-jar", "/app/docker-common-0.0.1-SNAPSHOT.jar"]