<?php

function print_error($msg){
    system(__DIR__ . "/../../../common/print.sh -error " . "'$msg'");
}

function print_success($msg){
  system(__DIR__ . "/../../../common/print.sh -success " . "'$msg'");
}
