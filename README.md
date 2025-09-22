Three easy way to use Java as script.

**1.)**
Assume you have a script written in Java and had to install some dependency :

```sh
mvn dependency:copy -Dartifact=com.fasterxml.jackson.core:jackson-databind:2.18.0 -DoutputDirectory=$(pwd)/libs
mvn dependency:copy -Dartifact=com.fasterxml.jackson.core:jackson-core:2.18.0 -DoutputDirectory=$(pwd)/libs
mvn dependency:copy -Dartifact=com.fasterxml.jackson.core:jackson-annotations:2.18.0 -DoutputDirectory=$(pwd)/libs
```

and run the script

```sh
mvn package #Not neede if you don't want to use pom.xml

java --class-path "libs/*" script.java
```
---

**2.)**
Shorter version of #1

```sh
#Install Dependency
mvn dependency:copy-dependencies \
 -DoutputDirectory=$(pwd)/libs \
 -DincludeGroupIds=com.fasterxml.jackson.core

#Run 
java --class-path "libs/*" script01.java

```
---

**3.)**
Use `jq` for the output.

```sh
java script02.java | jq '.'

java script02.java | jq '.name'
```