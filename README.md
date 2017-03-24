# database_examples

[![Build Status](https://travis-ci.org/springbootbuch/database_examples.svg?branch=master)](https://travis-ci.org/springbootbuch/database_examples)

## Building and Running

database_examples uses jOOQ code generation, so it needs a running PostgreSQL during build. The project also does some integration tests agains another PostgreSQL database running on docker which must be installed.

You can either setup PostgreSQL natively on your machine, create a database user `spring_postgres` with the same password having access to database `dvdrental` or use the Maven to fire up an instance on docker with

```
mvn docker:start
```

The project is ready configured to run agains this database.

Build it with 

```
mvn clean verify
```
