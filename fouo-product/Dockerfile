FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER fouo

RUN mkdir -p /things/gateway

WORKDIR /things/gateway

EXPOSE 18080

ADD ./target/miniapp-zcmanage.jar ./app.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]
