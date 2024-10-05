# addms-by-example

demo 01

- rest
  - openapi
- cdc
- kafka
- dataformat
- postgres
- 

```console
mvn archetype:generate -B -DarchetypeGroupId=org.apache.camel.archetypes -DarchetypeArtifactId=camel-archetype-java -DarchetypeVersion=3.18.4 -Dpackage=com.github.drr00t.addms -DgroupId=com.github.drr00t.addms -DartifactId=first-camel-integration -Dversion=1.0.0-SNAPSHOT
```

```console
mvn io.quarkus:quarkus-maven-plugin:3.15.1:create \
    -DprojectGroupId=com.github.drr00t.addms \
    -DprojectArtifactId=getting-started \
    -Dextensions=camel-quarkus-log,camel-quarkus-timer
```
