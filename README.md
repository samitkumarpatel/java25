Download Dependenncy 

```sh
./apache-maven-3.9.11/bin/mvn dependency:copy -Dartifact=com.fasterxml.jackson.core:jackson-databind:2.18.0 -DoutputDirectory=$(pwd)/target
./apache-maven-3.9.11/bin/mvn dependency:copy -Dartifact=com.fasterxml.jackson.core:jackson-core:2.18.0 -DoutputDirectory=target
./apache-maven-3.9.11/bin/mvn dependency:copy -Dartifact=com.fasterxml.jackson.core:jackson-annotations:2.18.0 -DoutputDirectory=target
```

and run the script

```sh
java --class-path "target/*" script.java
```
