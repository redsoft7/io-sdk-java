#!/bin/bash
cd "$(dirname $0)"
#if ! test -f build/libs/io-sdk-java.jar
#then echo "preparing archive, please wait..."
    export ORG_GRADLE_PROJECT_databaseType=mysql
    ./gradlew clean jar
#fi
wsk action update iosdk/import build/libs/io-sdk-java.jar --main Main --docker openwhisk/actionloop-java-v8:nightly
