#!/bin/sh

cd $(dirname "$0")
(
    cd src/test/java
    zip ../../../tmp/solution-sarah-lee.zip Tour.java InputReader.java NearestInsertion.java SmallestInsertion.java
)

unzip -l tmp/*.zip
