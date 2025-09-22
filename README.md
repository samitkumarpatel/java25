Download Dependenncy 

```sh
mvn dependency:copy -Dartifact=com.fasterxml.jackson.core:jackson-databind:2.18.0 -DoutputDirectory=$(pwd)/libs
mvn dependency:copy -Dartifact=com.fasterxml.jackson.core:jackson-core:2.18.0 -DoutputDirectory=$(pwd)/libs
mvn dependency:copy -Dartifact=com.fasterxml.jackson.core:jackson-annotations:2.18.0 -DoutputDirectory=$(pwd)/libs
```

and run the script

```sh
mvn package #Not neede if you don't want to use pom.xml

java --class-path "target/*" script.java
```
