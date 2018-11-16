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
6. First hit start for http://localhost:8080/vehicles on the right hand site of the site. Then hit start for http://localhost:8080/readings. This will start persisting data in MySql.
7. Now run the below URL's in Postman:
   a) All Vehicle Details : http://localhost:8080/getAllVehicleDetails (GET Request)
   b) Historical Alerts for a vehicle : http://localhost:8080/getVehicleAlerts/{vin} ((GET Request))
       vin - This is the vehicles Identification number (You can see this in the Database in the vehicle table)
   c) High Alerts for all Vehicles in the past 2 hours : http://localhost:8080/getHighAlerts (GET Request)
  
```

 <img width="1440" alt="screen shot 2018-11-15 at 11 16 52 pm" src="https://user-images.githubusercontent.com/37518846/48597612-b045d700-e92c-11e8-8fee-3cefd44dc510.png">
 

## Built With

* [Spring Boot](https://spring.io/guides/gs/spring-boot/) - The web framework
* [MySql](https://www.mysql.com/) - Database
* [Maven](https://maven.apache.org/) - Dependency Management
 
## Author

* **Karan Saini** - [Karan Saini](https://github.com/KaranSaini92837)
