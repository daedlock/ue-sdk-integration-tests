#!/bin/bash

#Colors
red="\033[01;31m";
green="\033[01;32m";
gray="\033[01;39m";
reset="\033[01;0m";

#Emoji
check="✔";
cross="✖";


success ()
{
    echo -e $green $check $gray $* $reset [$green OK $reset]
}

error () {
   echo -e $red $cross $gray $* $reset [$red FAIL $reset]
}

case $1 in
  -error)
    msg=$(error $2)
    ;;
  -success)
    msg=$(success $2)
    ;;
  *)
     echo $"Usage: $0 {-success|-error} <msg>"
     exit 1
esac

echo $msg;
