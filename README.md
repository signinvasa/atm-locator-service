# ATM locator service 
This is spring boot application which locates all the ATM's that are available in Netherlands. It uses external service API https://www.ing.nl/api/locator/atms/ to fetch the information

It also provides API to find all the ATMs within a particular city. The URL needs additional request parameter 'city' to identify the ATMs in that given city, ex:'?city=deventer'

# Features
Following features are implemented in the code
- <b>Caching</b> (Used spring boot cache feature, to avoid external API call for every request. Invalidating cache for every 1 hour)
- <b>Exception handling</b> (returning appropriate response with message in case of exception scenarios)
- <b>Fault tolerance</b> (Configured Hystrix for fault tolerance )
- <b>Content negotiation</b> (Returns data in JSON or XML format based on the 'Accept' header value 'application/json' or 'application/xml' )
- <b>HATEOAS</b> (hypermedia-driven REST web service)
- <b>JUnits</b> for API testing and also for service methods


# Endpoints

- 'hostname:port'/api/v1/locator/atms  To fetch all the available ATMs 
	 <b>ex: localhost:8888/api/v1/locator/atms</b>
- 'hostname:port'/api/v1/locator/atms?city='cityname' To fetch ATMs in a city  
	 <b>ex: localhost:8888/api/v1/locator/atms?city=deventer</b>
	 
# Steps to call the API using postman
- Install postman. here link shows the installation procedure 
	- https://learning.postman.com/docs/getting-started/installation-and-updates/
	
- Open the postman application and enter below URLs

	- To fetch all ATMs - http://localhost:8888/api/v1/locator/atms  
		- Select HTTP method as GET  
	
	- To fetch atms with in a particular city - http://localhost:8888/api/v1/locator/atms?city=deventer
		- Select HTTP method as GET
 	
- By default the above APIs return the JSON response. pass the 'Accept' header with value 'application/xml' if response is needed in XML format. 


# Steps to run the application in local machine
- Clone or download the repositoy to into your computer
- link shows how to clone a repository https://docs.github.com/en/github/creating-cloning-and-archiving-repositories/cloning-a-repository.
- Navigate the root folder where you cloned the project
- Run the maven command <b>mvn clean install </b>
	this should download all the dependancies and build the project. It also execute the Junits, use the switch -DskipTests to skip the tests
- Now run the the spring boot application using <b> mvn spring-boot:run </b>
	
# Prerequisite softwares
- Java8 need to be installed - https://docs.oracle.com/javase/8/docs/technotes/guides/install/windows_jdk_install.html
- Maven (version 3.8.1 or higher) need to be installed -  https://maven.apache.org/install.html
	

  