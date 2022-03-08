#!/bin/bash
go build go/Driver.go
./Driver
python3 python/driver.py

cd java-resume-parser
gradle clean build
gradle -q --console plain run