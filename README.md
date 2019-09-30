## Installation
### Clone Repository
```
git clone https://github.com/SanderV1992/Weather-Forecast-API-for-Tallinn.git
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

### Swagger
```
/api/swagger-ui.html
```

---

## Api Documentation

| resource      | description                       |
|:--------------|:----------------------------------|
| `/api/forecasts/places`                 | returns a list of places
| `/api/forecasts/places/temperature`     | returns a list of places, filtered by temperature
| `/api/forecasts/places/winds`           | returns a list of places, filtered by winds
| `/api/forecasts/phenomenon-types`       | returns a list of phenomenon types
| `/api/forecasts/time-of-day-types`      | returns a list of time of day types
| `/api/forecasts/place-types`            | returns a list of place types
| `/api/forecasts/wind-types`             | returns a list of wind types
