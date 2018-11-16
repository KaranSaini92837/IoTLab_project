IoTLab_project

# Project Title

This is a REST API which I have built to constantly take readings for vehicles and track the health of the vehicle by giving them alerts on specific events. I have used Spring Boot as my Web Framework and used MySql for persisting data with the help of Hibernate.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What things you need to install the software and how to install them

```
Postman - https://www.getpostman.com/apps
MySql - 
  For MacOs - https://dev.mysql.com/doc/refman/5.7/en/osx-installation-pkg.html
  For Windows - https://dev.mysql.com/doc/refman/5.7/en/mysql-installer.html
  For Unix/Linux - https://dev.mysql.com/doc/refman/5.7/en/binary-installation.html
```

### Installing

A step by step series of examples that tell you how to get a development env running

```
1. Clone the project in your local machine
2. Open this folder in an IDE(Eclipse, IntelliJ etc).
3. Create a Schema name IoT in MySql.
4. Now run the Application from the IDE. For running in the IDE run KaranSainiIoTLabProjectApplication.java
5. Now start your web browser and hit http://mocker.ennate.academy/
6. First hit start for http://localhost:8080/vehicles on the right hand site of the site. Then hit start for                      http://localhost:8080/readings. This will start persisting data in MySql.
7. Now run the below URL's in Postman:
   a) All Vehicle Details : http://localhost:8080/getAllVehicleDetails (GET Request)
   b) Historical Alerts for a vehicle : http://localhost:8080/getVehicleAlerts/{vin} ((GET Request))
       vin - This is the vehicles Identification number (You can see this in the Database in the vehicle table)
   c) High Alerts for all Vehicles in the past 2 hours : http://localhost:8080/getHighAlerts (GET Request)
  
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Built With

* [Spring Boot](https://spring.io/guides/gs/spring-boot/) - The web framework used
* [MySql] (https://www.mysql.com/) - The database used
* [Maven](https://maven.apache.org/) - Dependency Management
 
## Authors

* **Karan Saini** - [Karan Saini](https://github.com/KaranSaini92837)

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
