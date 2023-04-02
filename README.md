# Rewards Engine
A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.

A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every
dollar spent between $50 and $100 in each transaction.
(e.g., a $120 purchase = 2x$20 + 1x$50 = 90 points).

To build the application, run the following command.
```
$  ./gradlew clean :engine:build 
```
To build the Docker image
```
$ ./gradlew clean :engine:build :engine:docker 
```
To run in your local
```
$ cd rewards
$ java -jar -Dhostname=localhost ./engine/build/libs/engine-0.0.1-SNAPSHOT.jar
```
### Related Documentations

* [Swagger](http://localhost:8082/localhost/rewards/swagger-ui.html) - available when the application starts
* [Code Coverage](./engine/build/reports/jacoco/test/html/index.html) - Jacoco code coverage after the build
* [Test Reports](./engine/build/reports/tests/test/index.html) - Test reort after the build

