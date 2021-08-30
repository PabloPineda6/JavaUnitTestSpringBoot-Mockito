# Master Java Unit Testing with Spring Boot & Mockito
Learn to write awesome Java JUnit unit tests with Spring Boot, Mockito, JsonAssert, Hamcrest & JsonPath in 40 easy steps

### Project created while taking the course: 
https://www.udemy.com/course/learn-unit-testing-with-spring-boot/

### Reference URLs, code repository and course updates;
https://github.com/in28minutes/spring-unit-testing-with-junit-and-mockito

### For a Mockito FAQ, visit:
https://github.com/mockito/mockito/wiki/FAQ

### To help you unit test different patterns like Data Bases, internal interfaces, Mocks, refactoring Test code, etc.
http://xunitpatterns.com/


### If you are using Intellij or Java 9 or facing a ClassNotFoundException, here's the Quick Start with Top 10 FAQ
https://github.com/in28minutes/in28minutes-initiatives/blob/master/The-in28Minutes-TroubleshootingGuide-And-FAQ/quick-start.md

## To launch an API request and/or check the Data Base:
1. Run UnitTestingApplication file (src/main/java/com.unittestingproject.unittesting) with Java (it should launch using Sprint)
2. Type, in a browser, the route of the request, as named in the controller (http://localhost:8080/get-response or http://localhost:8080/item-from-business-service)
3. Type, in a browser, the route to the local Data Base (http://localhost:8080/h2-console)
   1. make sure the JDBC URL is <jdbc:h2:mem:testdb> (as defined in application.properties file) and click connect
4. Verify the response matches the expectations


### BETTER ASSERTIONS

There are three frameworks to improve the level of assertions in a test: Hamcrest methods, Json assert (AssertJ) and Json path

1. To use the hamcrest library, you need to have these settings in your static preferences

In Eclipse: Go to preferences -> Static -> Favorites. Then add (in New Type):
- org.hamcrest.CoreMatchers (should already be there)
- org.hamcrest.MatcherAssert
- org.hamcrest.Matchers

In Intellij: Go to File -> Settings -> Code Style -> Java -> Imports. Then, add (and select static):
- org.hamcrest.CoreMatchers
- org.hamcrest.MatcherAssert
- org.hamcrest.Matchers

Then, where you create your assertions, you would want to import:
- import static org.hamcrest.MatcherAssert.*;
- import static org.hamcrest.Matchers.*;

2. To use Json assert (AssertJ), you need to have these settings in your static preferences

In Eclipse: Go to preferences -> Static -> Favorites. Then add (in New Type):
- org.assertj.core.api.Assertions (should already be there)

In Intellij: Go to File -> Settings -> Code Style -> Java -> Imports. Then, add (and select static):
- org.assertj.core.api.Assertions (should already be there)

Then, where you create your assertions, you would want to import:
- import static org.assertj.core.api.Assertions.assertThat;



### SPECIAL CONSIDERATIONS DEPENDING ON EACH PROJECT
1. In this application, we are using an in-memory Data Base as the projects DB, in real world applications, you'll be talking to real DB.
In those situations, move data.sql to the route src/test/resources, and then, that data will be used only for Unit tests (Spring Boot DataJpaTest initializes the DB using that file).

2. Use @MockBean to mock dependencies outside the Integration test you want to do
and have them return whatever works for the test you want to do.
For example:
@MockBean
private ItemRepository repository;
3. If you have a src/test/resources/application.properties file. When making tests, whatever is written there overwrites what is in the
   src/main/resources/application.properties file. This last file would manage the properties for the application's regular behaviour.
If you don't have the first uppermentioned file. The second one would manage the properties for both the regular behaviour and the tests.
4. If you need a specific configuration for a given test: Right above the definition of the class, you can use the @TestPropertySource annotation.
For example: @TestPropertySource(locations = {"classpath:test-configuration.properties"})
// <you need to create the test-configuration.properties file in src/test/resources/test-configuration.properties>

