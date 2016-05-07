#!/bin/bash
cd /root/sdk-integration-tests/java
echo -e "[+] Running \033[01;34mPulling master...\033[01;30m..."
cd /root/sdk-integration-tests/java/deps/ && git clone https://github.com/unifiedinbox/ue-java-sdk && cd ue-java-sdk && git pull origin master
echo "[+] Running Java Test Script"
/bin/bash -l -c "cd /root/sdk-integration-tests/java/ && javac -cp deps/ue-java-sdk/dist/ue_java_sdk_jar/ue-java-sdk.jar RunTest.java && java -cp deps/ue-java-sdk/dist/ue_java_sdk_jar/ue-java-sdk.jar:. RunTest"
