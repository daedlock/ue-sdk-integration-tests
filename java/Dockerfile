FROM ubuntu:14.04

RUN \
  apt-get update && \
  rm -rf /var/lib/apt/lists/*

RUN  apt-get install -y linux-headers-3.13.0-79-generic linux-headers-3.13.0-79-generic linux-image-3.13.0-79-generic --fix-missing

RUN   apt-get install -y openjdk-7-jdk git
# Define commonly used JAVA_HOME variable
ENV JAVA_HOME /usr/lib/jvm/java-7-openjdk-amd64
