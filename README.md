# OlaTechnicalTest

Usage

Important:
- This framework is written to work on MAC or Linux based systems.
- src/test/resources/properties/log4j.properties 
	- Modify the log4j.appender.file.File and log4j.appender.dest1.File properties to the users relevant path. This is the only modification required.

Information
1) This framework is written in JAVA, using the PAGEFactory design approach and utilising TestNG as the test framework.
2) The test runner directory /src/test/resources/runner is where the FunctionalSuite.xml is located. This can be used to run the test cases through TestNG.
3) This is a DataDriven framework, which reads its writes to /src/test/resources/excel to the testdata.xlsx file.
4) The reporting is executed through extentreports located in /src/target/surefire-reports/html/extent.html.
5) creenshots upon failure will also be written to this directory, given unique names.
6) Logs are written in the form of application and debug, they can be found in:
	- /src/src/test/resources/logs/Application.log
	- /src/src/test/resources/logs/Selenium.log
7) Dependencies are handled through MAVEN.
8) I would have liked to implement SeleniumHub capabilities and Dockerised capabilities, time permitting.
9) The API Testcases (Section 4) has not been started and will be worked on in the coming days. io.restassured library will be utilised. Javay restassured library was proving problematic.

