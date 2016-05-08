This repo holds the integration tests for each of the UnificationEngine client SDKS. Integration tests included for the following clients
- JAVA
- Ruby
- NodeJS
- PHP


# Prerequisites
To minimize the installation burden for dependencies, languages, libraries needed by each SDK. We have used Docker and Docker Compose to automate the whole process. To run the tests you need to have `docker` and `docker-compose` installed.

### Docker Installation
https://docs.docker.com/engine/installation/


### Docker Compose Installation
https://docs.docker.com/compose/install/


# How to run
### Build docker containers specified in _doccker_compose.yml
```bash
docker-compose build
```

### Run all tests from all sdks
```bash
docker run java
docker run php
docker run node
docker run ruby
```