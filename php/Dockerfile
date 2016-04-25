FROM ubuntu:14.04

#Update and install PHP 5.6 and dependencies
RUN apt-get update && apt-get install -y git curl wget software-properties-common
RUN add-apt-repository ppa:ondrej/php5-5.6
RUN apt-get update
RUN apt-get install -y php5

#Install Composer
RUN php -r "readfile('https://getcomposer.org/installer');" | php

#Install PHPUnit
RUN cd /
RUN wget https://phar.phpunit.de/phpunit.phar
RUN chmod +x phpunit.phar
