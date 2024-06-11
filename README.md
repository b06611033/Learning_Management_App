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

## Deploy to AWS Elastic Beanstalk
1. Change packaging to WAR and include Tomcat dependencies in pom.xml

```
<packaging>war</packaging>

<dependencies>
    <dependency>
        <groupId>org.apache.tomcat.embed</groupId>
        <artifactId>tomcat-embed-jasper</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-tomcat</artifactId>
    </dependency>
</dependencies>
```

2. Extend SpringBootServletInitializer in the main application

```
@SpringBootApplication
public class TodolistApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TodolistApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

}
```

3. Modify server port and database info in application properties

```
server.port=5000
spring.datasource.url=jdbc:mysql://${RDS_HOSTNAME:localhost}:${RDS_PORT:3306}/${RDS_DB_NAME:(Your database name)}
spring.datasource.username=${RDS_USERNAME:(Your database username)}
spring.datasource.password=${RDS_PASSWORD:(Your database password)}
```

4. Put JSP files under .../src/main/webapp/WEB-INF (AWS Tomcat might not be able to locate the JSP files if structure is different)

5. Use following command to create WAR file

```
maven build clean package
```

6. Create Elastic Beanstalk application 

7. Choose Tomcat as platform and upload your WAR file

8. Choose roles and choose MySQL database

9. Deploy application