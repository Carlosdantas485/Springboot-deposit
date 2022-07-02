# Getting started with Java and Spring-boot

![](https://github.com/flavours/documentation/workflows/CI/badge.svg)

<p align="center">
  <img src="https://utils.flavours.dev/presskit/spring_boot_flavour_glossy.svg" width="100">
</p>

## Quick start

### Clone the repository

```
git clone https://github.com/Carlosdantas485/Springboot-deposit.git
```

### Build the project

```
cd getting-started-with-spring-boot
docker-compose build
```

The project includes a ``web`` service, running the Java code, and a ``db`` service, running a Postgres database.
See the ``docker-compose.yml`` file for details.

### Run the project

```
docker-compose up
````

Containers for both services will be launched. The project can be reached at http://localhost:8000.

Hot-reloading is enabled (i.e. changes to the Java code in the project will cause the application to restart so that they 
can be used.)


## How to

### Run the local project on a different port

The container runs a Tomcat server listening on port 8080. The ``docker-compose.yml`` file is set up to
expose this port to the Docker host at port 8000, but you are free to change it as you wish - edit the ``ports`` directive:

```
services:
  web:
    [...]
    ports: 
      - 8000:8080
```

### Contribute to the project

See the [contribution guide](https://github.com/flavours/getting-started-with-spring-boot/blob/master/CONTRIBUTING.md).


### How to prepare a new release of the getting-started project###
To create a new release of the getting started project, you have to updated the default welcome screen with the latest version.

```
docker run --rm --volume "`pwd`:/data" --user `id -u`:`id -g` pandoc/core:2.9.2 -s --css https://utils.flavours.dev/baseproject/1.0/style.css -o /data/src/main/resources/templates/index.html /data/README.md
```

Please also update the changelog accordingly and tag a new release in github.


### External how-to guides

* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Accessing Relational Data using JDBC with Spring](https://spring.io/guides/gs/relational-data-access/)
* [Managing Transactions](https://spring.io/guides/gs/managing-transactions/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)


## Reference

This project template uses:

* [Spring JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/) for database access
* [Spring Web](https://spring.io/guides/gs/serving-web-content/) to serve HTTP requests


