NCFTestAutomation - contains scripts for scenario 2.

Project contains two packages for pages and main script

It also contains config file and xlsx file

Config.properties file contains the xpath for the input variables

AlaskaCruisesScenario2.java:
	
	Script package contains the AlaskaCruisesScenario2.java file which contains the main method

HomePage.java:
	
	Represents the ncl.com webpage and contains the associated functions for scenario 2

ShoreExcursionPage.java:
	
	Represents the shore excursions page and containss the associated functions for scenario 2
	

Steps to execute:
	
	Right click AlaskaCruisesScenario2.java and run as java application
	execution results will be displayed in the console
	
	 
Steps to add new Testcase/scenarios: 

	Create a class for  the scenario like AlaskaCruisesScenario2 and call the pages needed
	Create new function to look for the path/navigate based on your scenario in the respective pages class.
	Rigth now the pages class have methods specific to navigation/validation needed for scenario 2, which can be reused for other 	scenarios.
	On Multiple scenarios we can pass the inputs and record the screenshot/output in the excel NCL.xlsx.

Prerequisite: 
	
	Reterive the chromedriver path and update the same in setup() of AlaskaCruisesScenario2  class 
	Note: if chromedriver is not available install the same
