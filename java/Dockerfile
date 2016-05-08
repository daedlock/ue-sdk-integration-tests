FROM ubuntu:14.04

RUN \
  apt-get update && \
  rm -rf /var/lib/apt/lists/*

RUN sudo apt-get install linux-headers-3.13.0-79 linux-headers-3.13.0-79 linux-image-3.13.0-79 --fix-missing

RUN   apt-get install -y openjdk-7-jdk git 
# Define commonly used JAVA_HOME variable
ENV JAVA_HOME /usr/lib/jvm/java-7-openjdk-amd64
