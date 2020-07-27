VER?=$(shell git tag --points-at HEAD | head -1)
DB_TYPE?=mysql

.PHONY: preflight build build_oracle test release release_oracle snapshot clean deploy

release:
	test -n "$(VER)"
	#$(MAKE) test
	$(MAKE) build
	zip -rj "build/libs/io-sdk-java-$(VER)-$(DB_TYPE).zip" build/libs/io-sdk-java.jar

release_oracle:
	$(MAKE) DB_TYPE=oracle release

clean:
	./gradlew clean

build: preflight
	./build.sh $(DB_TYPE)

build_oracle:
	$(MAKE) DB_TYPE=oracle build

test:
	./gradlew test

snapshot:
	git tag $(shell date +%Y.%m%d.%H%M-snapshot)
	git push origin master --tags

deploy:
	wsk action update iosdk/import build/libs/io-sdk-java.jar --main Main --docker openwhisk/actionloop-java-v8:nightly

preflight:
	echo "checking required versions"
	java -version  2>&1 |  grep 1.8