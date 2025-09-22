Download Dependenncy 

**1.)**

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

**2.)**

```sh
#Install Dependency
mvn dependency:copy-dependencies \
 -DoutputDirectory=$(pwd)/libs \
 -DincludeGroupIds=com.fasterxml.jackson.core

#Run 
java --class-path "libs/*" script01.java

```

**3.)**

```sh
java script02.java | jq '.'

java script02.java | jq '.name'
```