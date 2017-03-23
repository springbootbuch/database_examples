# database_examples

[![Build Status](https://travis-ci.org/springbootbuch/database_examples.svg?branch=master)](https://travis-ci.org/springbootbuch/database_examples)

## Running

You'll need PostgreSQL listening to its standard port on your host.

Use

```
mvn docker:start
```

to startup a container.

## Building

The project does some integration tests using docker. You got to have Docker installed for your system to build the project using

```
mvn clean verify
```