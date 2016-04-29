#!/bin/bash
cd /root/sdk-integration-tests/ruby
/bin/bash -l -c "rvm use 2.1.8"
echo -e "[+] Running \033[01;34mbundle install\033[01;30m..."
/bin/bash -l -c  bundle   > /dev/null 2>&1 #suppress
echo "[+] Running ruby Test Script"
/bin/bash -l -c "ruby run-test.rb"
