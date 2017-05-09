## Spring Boot Demo

### How to run
#### run in IDE:

run SpringBootDemoApplication main() in IDE 

#### run in cmd:

```mvn spring-boot:run```

#### using java jar:
* step 1:
```mvn install```
* step 2:
```java -jar target/spring-boot-demo-0.0.1-SNAPSHOT.jar```

##### add additional param in jar command
* use spring.profiles.active to specify the boot environment  
```java -jar target/spring-boot-demo-0.0.1-SNAPSHOT.jar --spring.profiles.active=prd```