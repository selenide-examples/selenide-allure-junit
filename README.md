# Selenide basic example with following integrations working out of the box:
- Allure 1.5
- Parallel org.selenide.examples.config.tests execution with JUNIT JVM Fork
- Jenkins integration via Jenkinsfile pipeline script
- Local grid supplied in /grid directory
- Example runners in prokect root eg. /run_parallel.bat

## To run org.selenide.examples.config.tests and generate Allure report:

* run `mvn clean test` or use maven wrapper `mvnw clean test`
* run `mvn site` or use maven wrapper `mvnw clean test`

## To see a report:

1. run `mvn jetty:run`
2. open `http://localhost:8080` in your browser
