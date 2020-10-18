FROM ubuntu:18.04

RUN apt-get update

RUN apt-get -qq install default-jdk -y 

RUN apt-get -qq install maven -y 

EXPOSE 8080

EXPOSE 9001

ADD / /code/

WORKDIR /code

CMD mvn exec:java -DskipTests -Dexec.mainClass=app.Application