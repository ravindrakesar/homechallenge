# homechallenge

*This is a API testing framework with following tech stack*

* Maven
* Cucumber
* Rest assured Java data

*Set up this API testing project by cloning the project*

*Swagger pet store API project should be set up on local machine before running the API tests*

**https://github.com/swagger-api/swagger-petstore**

*Refer the readme file in above project to set up and start the jetty server*

**Only the pet APIs are automated**

**Ways to run the API tests**
# We can run the API tests by following ways 
* From src/test/java/features folder we can run each feature file
* From src/test/java/cucumberTest/TestRunner.java we can run all scenarios at once
* JSON reports can be found at target\jsonReports
* After running the test runner file, run mvn verify command from terminal
* This will create cucumber HTML reports which can be found at ./target/cucumber-html-reports/overview-features.html

# Improvements
* JSON parser implementation for JSON response body verification


