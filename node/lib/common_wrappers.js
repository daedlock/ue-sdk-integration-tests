require('shelljs/global');


function printError($msg){
    exec(__dirname + "/../../common/print.sh -error " + "'" + $msg + "'").output;
}

function printSuccess($msg){
  exec(__dirname + "/../../common/print.sh -success "  + "'" + $msg + "'").output;
}

module.exports = {
  printSuccess: printSuccess,
  printError: printError
}
