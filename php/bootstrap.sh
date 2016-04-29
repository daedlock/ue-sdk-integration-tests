#!/bin/bash
cd /root/sdk-integration-tests/php
echo -e "[+] Running \033[01;34mcomposer install\033[01;30m..."
/composer.phar install > /dev/null 2>&1 #suppress
echo "[+] Running PHP Test Script"
php run-test.php
