# Selenide + Allure + JUnit example

## To run tests and generate Allure report:

* run `mvn clean test`

## To access the report manually:
1. Generate the report by running: `mvn allure:report`
2. Use an HTTP server to expose the content of `target/site/allure-maven-plugin/` <br/>
In [Intellij IDEA](https://www.jetbrains.com/idea/), you can access the report by opening `target/site/allure-maven-plugin/index.html` in [the Web Browser](https://www.jetbrains.com/help/idea/configuring-third-party-tools.html#web-browsers).

## To access the report automatically:
To Generate and open the report in your default browser at:
  + Random port, run: `mvn allure:serve`
  + Specific port, run: `mvn allure:serve -Dallure.serve.port={your_port}`



[![Build Status](https://travis-ci.org/selenide-examples/selenide-allure-junit.png)](https://travis-ci.org/selenide-examples/selenide-allure-junit)