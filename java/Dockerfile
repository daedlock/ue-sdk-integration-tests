FROM ubuntu:12.04


RUN  apt-get purge openjdk-\* icedtea-\* icedtea6-\*

RUN \
  apt-get update && \
  apt-get install -y openjdk-7-jdk git && \
  rm -rf /var/lib/apt/lists/*




# Define commonly used JAVA_HOME variable
ENV JAVA_HOME /usr/lib/jvm/java-7-openjdk-amd64
