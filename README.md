#Prime Number Generator

Steps :
1. import the project in eclipse using "Existing Maven Project".
2. run the project using "Run as Java Application" with the main class present in "ApplicationStart.java".
3. Please go through "RequestResponseFormat.xls" excel to hit the end point URL.


Request Type								End Point URL									Request Format
GET Request									http://localhost:8080/getPrimeNumbers	
POST Request For Setting upper Limit		http://localhost:8080/setUpperLimit				"{"upperLimit" :{UPPER_LIMIT_VALUE_IN_INTERGER}}"
