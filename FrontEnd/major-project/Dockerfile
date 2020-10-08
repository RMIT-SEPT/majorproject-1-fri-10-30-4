FROM ubuntu:18.04

RUN apt-get update

RUN apt-get -qq install npm -y
 
EXPOSE 8080

EXPOSE 80

ADD / /code/

WORKDIR /code

CMD npm start