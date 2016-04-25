#!/bin/bash

#Colors
red="\033[01;31m";
green="\033[01;32m";
reset="\033[01;0m";

#Emoji
check="✔";
cross="✖";


success ()
{
    echo -e $green $"$check" $reset $*
}

error () {
   echo -e $red $cross $reset $*
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
