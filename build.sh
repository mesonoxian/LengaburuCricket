#!/usr/bin/env bash

rm -rf out/*

javac src/*.java -d out

jar cfve ./out/cricket.jar Main  -C out .

