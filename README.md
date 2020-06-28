# io-sdk-java
Java importer


## Run test

* Start local mysql  
`cd utils/mysql`  
`docker-compose up -d`
* Start local oracle  
`cd utils/oracle`  
`docker-compose up -d`
* Wait for local databases to start
* Run test  
`gradlew test`
* Stop local mysql  
`cd utils/mysql`  
`docker-compose down -v`
* Stop local oracle  
`cd utils/oracle`  
`docker-compose down -v`

## Mysql

### Build IO-SDK action for Mysql
`./build.sh mysql`

## Oracle

### Build IO-SDK action for Oracle
`./build.sh oracle`

