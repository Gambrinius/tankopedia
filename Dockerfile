FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/tankopedia.jar /tankopedia/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/tankopedia/app.jar"]
