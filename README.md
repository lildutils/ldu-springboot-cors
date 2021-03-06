# ldu-springboot-cors

## Prerequisites

* [JDK](https://www.oracle.com/technetwork/java/javase/downloads/index.html) - jdk1.8.0_201
* [AdoptOpenJDK](https://adoptopenjdk.net/index.html) - jdk8u242-b08
* [Gradle](https://gradle.org/releases/) - 5.6.2
* [IDE *(recommended)*](https://spring.io/tools) - latest

## Development

### Configurations

```properties
# application.properties

ldu.cors.origin.header-name=stringValue
ldu.cors.allowed-origins=comma, separated, string, values
ldu.cors.allowed-methods=comma, separated, string, values
ldu.cors.allowed-headers=comma, separated, string, values
ldu.cors.exposed-headers=comma, separated, string, values
ldu.cors.allowed-credentials=booleanValue
ldu.cors.expiration-time=integerValue
```

```yaml
# application.yml

ldu:
  cors:
    origin:
      header-name: stringValue
    allowed-origins: comma, separated, string, values
    allowed-methods: comma, separated, string, values
    allowed-headers: comma, separated, string, values
    exposed-headers: comma, separated, string, values
    allowed-credentials: booleanValue
    expiration-time: integerValue
```

### Install

```Gradle
gradle init
```

### Build

```Gradle
gradle build
```

## About

To get more informations about this library, or if you have any question or suggestion, please send an email to [me](mailto:lildworks@gmail.com)

## 

Thanks :)
