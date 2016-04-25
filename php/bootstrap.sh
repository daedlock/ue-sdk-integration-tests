#!/bin/bash
echo "[*] RUNNING bootstrap.sh"
cd /root/php
# /composer.phar install
# php run-test.php
echo "[*] Testing"
/phpunit.phar tests/test1.php
