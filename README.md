# Selenide + Allure + JUnit example

## To run tests and generate Allure report:

* run `mvn clean test`

## To access the report manually:
1. Generate the report by running: `mvn allure:report`
2. open `target/site/allure-maven-plugin/index.html`

## To access the report automatically:
To Generate and open the report in your default browser at:
  + Random port, run: `mvn allure:serve`
  + Specific port, run: `mvn allure:serve -Dallure.serve.port={your_port}`



[![Build Status](https://travis-ci.org/selenide-examples/selenide-allure-junit.png)](https://travis-ci.org/selenide-examples/selenide-allure-junit)