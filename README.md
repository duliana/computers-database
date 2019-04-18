# computer-database

Test automation framework for testing Play sample application ? Computer database.

Website: http://computer-database.herokuapp.com/computers

Requirements:
- Gradle 2.7
- Java 8
- TestNG
- Chrome browser

Test Cases: ComputerDatabaseTests.pdf

How to run it:
- Download project
	git clone https://github.com/duliana/computers-database.git

- Inside the folder of the downloaded folder run:
    gradle test
    (This command will build and run all tests)

    Extent Reporting:
    After the execution the report will be generated and put in build/reports/tests/test/ as index.html
    The report can be opened and reviewed in browser window.

Notes:
- src.test.java.cases.computers folder contains regression tests for CRUD operations covering:
  - Add computers tests
  - Search computers tests
  - Edit computers tests
  - Delete computers tests

- If tests are failing they can be annotated with @BugInfo intended to provide the Jira ticket id or some other notes for failing tests
