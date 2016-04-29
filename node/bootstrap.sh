#!/bin/bash
cd /root/sdk-integration-tests/node
echo -e "[+] Running \033[01;34mnpm install\033[01;30m..."
npm install --silent > /dev/null 2>&1
echo "[+] Running NodeJS Test Script"
node run-test.js
