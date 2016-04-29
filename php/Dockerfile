FROM ubuntu:14.04

#Update and install PHP 5.6 and dependencies
RUN apt-get update && apt-get install -y git curl wget php5-cli

#Install Composer
RUN php -r "readfile('https://getcomposer.org/installer');" | php
