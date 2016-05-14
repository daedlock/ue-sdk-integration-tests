# FROM ubuntu:12.04
#
#
# RUN  apt-get purge openjdk-\* icedtea-\* icedtea6-\*
#
# RUN \
#   apt-get update && \
#   apt-get install -y openjdk-7-jdk git && \
#   rm -rf /var/lib/apt/lists/*
#


FROM ubuntu:15.04
MAINTAINER Ivan Krizsan, https://github.com/krizsan
RUN apt-get update && \
    apt-get upgrade -y && \
    apt-get install -y  software-properties-common && \
    add-apt-repository ppa:webupd8team/java -y && \
    apt-get update && \
    echo oracle-java7-installer shared/accepted-oracle-license-v1-1 select true | /usr/bin/debconf-set-selections && \
    apt-get install -y oracle-java8-installer && \
    apt-get clean

RUN     apt-get install -y git


# Define commonly used JAVA_HOME variable
# ENV JAVA_HOME /usr/lib/jvm/java-7-openjdk-amd64
