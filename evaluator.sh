#!/bin/bash
cd go
go build Driver.go
./Driver
cd ../python
python3 driver.py

cd ../java-resume-parser
gradle clean build
gradle -q --console plain run