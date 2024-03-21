# Learning Management App

## Run locally
1. Install Docker
2. Pull MySQL Database Image in Docker with command

```
docker run --detach --env MYSQL_ROOT_PASSWORD=dummypassword --env MYSQL_USER=todos-user --env MYSQL_PASSWORD=dummytodos --env MYSQL_DATABASE=todos --name mysql --publish 3306:3306 mysql:8-oracle
```

3. Navigate to root directory of this project and run project with command

```
./mvnw spring-boot:run
```

## Inspect SQL Tables
1. Install mysqlsh
2. Access schema with commands below

```
mysqlsh
\connect todos-user@localhost:3306
\sql
use todos
```