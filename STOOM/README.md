# STOOM TEST

##To Generate .JAR
```bash
mvn clean install
```

### To Change Database
To development is used H2-Database.
### In pom.xml Change the dependency from the database. Ex to change to postgres:

Remove:
```pom
  <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
  </dependency>
```
add:
```pom
<!-- https://mvnrepository.com/artifact/org.postgresql/postgresql -->
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.2.23</version>
</dependency>
```

and change the properties:
```bash
spring.datasource.url=jdbc:h2:mem:stoomdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=secret
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

to:
```bash
spring.datasource.url=jdbc:postgresql://url_database/databasename
spring.datasource.driverClassName=org.postgresql.Driver
spring.datasource.username=database-username
spring.datasource.password=database-password
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQL94Dialect
```