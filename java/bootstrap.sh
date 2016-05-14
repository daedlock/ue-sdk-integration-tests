#!/bin/bash
cd /root/sdk-integration-tests/java
echo -e "[+] Running \033[01;34mPulling master...\033[01;30m..."
mkdir cd /root/sdk-integration-tests/java/deps
cd /root/sdk-integration-tests/java/deps/ && git clone https://github.com/unifiedinbox/ue-java-sdk
cd /root/sdk-integration-tests/java/deps/ue-java-sdk && git pull origin master
echo "[+] Running Java Test Script"
/bin/bash -l -c "cd /root/sdk-integration-tests/java/src && javac -cp /root/sdk-integration-tests/java/deps/ue-java-sdk/dist/ue-java-sdk.jar:. RunTest.java && java -cp /root/sdk-integration-tests/java/deps/ue-java-sdk/dist/ue-java-sdk.jar:. RunTest"
