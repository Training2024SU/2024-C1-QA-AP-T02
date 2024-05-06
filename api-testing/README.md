# Rest API Testing Workshop

Rest API testing workshop solution using rest assured in BDD style running with cucumber.

## How to run the tests

- Run the [RunRestTest](src/test/java/com/davidbonelo/runners/RunRestTest.java) class.
    - It's possible to filter by tags using the annotations
- Run a specific feature or scenario from [features/](src/test/resources/features)

to desable requests and responses login, delete line 18 from this file: [RestSetup](
src/test/java/com/davidbonelo/stepdefinitions/RestSetup.java)

## How to generate reports

- Run from the console with the command `./gradlew test --rerun-tasks --info`