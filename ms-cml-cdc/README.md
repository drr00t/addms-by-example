# ms-cml-cdc

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/ms-cml-cdc-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- Camel MongoDB ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/mongodb.html)): Perform operations on MongoDB documents and collections
- Camel Direct ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/direct.html)): Call another endpoint from the same Camel Context synchronously
- Hibernate ORM ([guide](https://quarkus.io/guides/hibernate-orm)): Define your persistent model with Hibernate ORM and Jakarta Persistence
- Camel Debezium PostgresSQL Connector ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/debezium-postgres.html)): Capture changes from a PostgresSQL database
- Camel Core ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/core.html)): Camel core functionality and basic Camel languages: Constant, ExchangeProperty, Header, Ref, Simple and Tokenize
- Camel Rest ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/rest.html)): Expose REST services and their OpenAPI Specification or call external REST services
- Agroal - Database connection pool ([guide](https://quarkus.io/guides/datasource)): Pool JDBC database connections (included in Hibernate ORM)
- Camel JPA ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/jpa.html)): Store and retrieve Java objects from databases using Java Persistence API (JPA)
- Camel JSON Path ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/jsonpath.html)): Evaluate a JSONPath expression against a JSON message body

## Provided Code

### Hibernate ORM

Create your first JPA entity

[Related guide section...](https://quarkus.io/guides/hibernate-orm)


https://camel.apache.org/blog/2023/05/camel-debezium-quarkus/
https://quarkus.io/guides/dev-services
https://quarkus.io/guides/getting-started-dev-services