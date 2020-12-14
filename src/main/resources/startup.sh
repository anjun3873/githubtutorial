#!/bin/bash
java -jar elis_main.war & echo $! > ./pid.file &