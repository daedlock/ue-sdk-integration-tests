#!/bin/bash
cd /root/sdk-integration-tests/php
/composer.phar install
php run-test.php
