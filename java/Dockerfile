FROM ubuntu:14.04

RUN \
  apt-get update && \
  apt-get install -y openjdk-7-jdk git && \
  rm -rf /var/lib/apt/lists/*

# Define commonly used JAVA_HOME variable
ENV JAVA_HOME /usr/lib/jvm/java-7-openjdk-amd64

WORKDIR /root/sdk-integration-tests/java/

RUN mkdir deps
RUN cd deps
RUN ls
RUN git clone https://github.com/unifiedinbox/ue-java-sdk
