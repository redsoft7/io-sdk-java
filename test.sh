#!/bin/bash
echo Starting test db
docker-compose -f utils/mysql/docker-compose.yml up -d
docker-compose -f utils/oracle/docker-compose.yml up -d
docker-compose -f utils/sqlserver/docker-compose.yml up -d
echo Waiting for database to start
sleep 30
if [ -z "$1" ]
  then
    ./gradlew test -x distributions
  else
    ./gradlew test -x distributions "-Dio-sdk-java.docker.ip=$1"
fi
echo Stopping test db
docker-compose -f utils/mysql/docker-compose.yml down -v
docker-compose -f utils/oracle/docker-compose.yml down -v
docker-compose -f utils/sqlserver/docker-compose.yml down -v
