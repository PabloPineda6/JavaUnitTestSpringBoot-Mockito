# Master Java Unit Testing with Spring Boot & Mockito
Learn to write awesome Java JUnit unit tests with Spring Boot, Mockito, JsonAssert, Hamcrest & JsonPath in 40 easy steps

### Project created while taking the course: 
https://www.udemy.com/course/learn-unit-testing-with-spring-boot/

### Reference URLs, code repository and course updates;
https://github.com/in28minutes/spring-unit-testing-with-junit-and-mockito

### For a Mockito FAQ, visit:
https://github.com/mockito/mockito/wiki/FAQ

### If you are using Intellij or Java 9 or facing a ClassNotFoundException, here's the Quick Start with Top 10 FAQ
https://github.com/in28minutes/in28minutes-initiatives/blob/master/The-in28Minutes-TroubleshootingGuide-And-FAQ/quick-start.md

## To launch an API request and/or check the Data Base:
1. Run UnitTestingApplication file (src/main/java/com.unittestingproject.unittesting) with Java (it should launch using Sprint)
2. Type, in a browser, the route of the request, as named in the controller (http://localhost:8080/get-response or http://localhost:8080/item-from-business-service)
3. Type, in a browser, the route to the local Data Base (http://localhost:8080/h2-console)
   1. make sure the JDBC URL is <jdbc:h2:mem:testdb> (as defined in application.properties file) and click connect
4. Verify the response matches the expectations

## SPECIAL CONSIDERATIONS DEPENDING ON EACH PROJECT
#### 1. In this application, we are using an in-memory Data Base as the projects DB, in real world applications, you'll be talking to real DB
In those situations, move data.sql to the route src/test/resources, and then, that data will be used only for Unit tests (Spring Boot DataJpaTest initializes the DB using that file)