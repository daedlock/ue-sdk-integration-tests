FROM ubuntu:14.04


RUN apt-get -y update && apt-get install -y curl


#RUBY
# RUN cd /tmp && wget http://ftp.ruby-lang.org/pub/ruby/2.3/ruby-2.3.0.tar.gz
# RUN cd /tmp && tar -xzvf ruby-2.3.0.tar.gz
# RUN cd /tmp/ruby-2.3.0/ && ./configure && make && make install
# RUN sudo apt-get install -y rubygems
# RUN gem install bundler


RUN gpg --keyserver hkp://keys.gnupg.net --recv-keys D39DC0E3
RUN /bin/bash -l -c "curl -L get.rvm.io | bash -s stable"
RUN /bin/bash -l -c "rvm install 2.1"
RUN /bin/bash -l -c "echo 'gem: --no-ri --no-rdoc' > ~/.gemrc"
RUN /bin/bash -l -c "gem install bundler --no-ri --no-rdoc"
