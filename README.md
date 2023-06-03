# vehicle-rental

deply to docher and start using right away

```shell
./mvnw clean package -DskipTests
```

```shell
cp target/vehicle-renter-0.0.1-SNAPSHOT.jar docker
cd docker
```

```shell
docker-compose up
```


port 8081 is set to be forwarded to the Spring Boot app 
port 5332 is set for the PostgreSQL database

you can test it by calling GET http://localhost:8081/api/v1/brands 
