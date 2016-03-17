FROM ubuntu:14.04

ENV JAVA_HOME /usr/lib/jvm/java-8-oracle

RUN apt-get -y update &&\
    apt-get -y install software-properties-common &&\
    add-apt-repository ppa:webupd8team/java &&\
    apt-get -y update &&\
    echo debconf shared/accepted-oracle-license-v1-1 select true | sudo debconf-set-selections &&\
    echo debconf shared/accepted-oracle-license-v1-1 seen true | sudo debconf-set-selections &&\
    apt-get -y install oracle-java8-installer &&\
    apt-get -y install openssh-server &&\
    apt-get -y install unzip
    


ENV DEBIAN_FRONTEND=noninteractive

EXPOSE 22
