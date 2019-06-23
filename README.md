# Find all burger venues in Tallinn and Tartu

With this application you can find all burger venues, with their latest photo, google map coordinates and details,
and also determines if the photo is a burger.

## Installation
### Clone Repository
```
git clone https://github.com/SanderV1992/Burger-Finder-Application.git
```

### Project build
```
mvn clean install
```

### Run
```
mvn --projects application spring-boot:run
mvn --projects application spring-boot:run -Drun.jvmArguments='-Dserver.port=8081'
```

### Run jar file
```
java -jar ./application/target/application-1.0.jar
```

---

#### Link to the application:
- https://burger-finder-application.herokuapp.com/
