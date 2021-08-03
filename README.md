# Library-service
![Library logo](library.jpg)

Very simple library application. You can adding, deleting and editing information about authors and books.
## Technologies used

* Spring Boot (Web, Data JPA)
* MySQL

## To run the app you will need:

**1.** Clone this project

**2.** Insert your own MySQL username and login in "src/main/resources/application.properties":
- USERNAME: "your username"
- PASSWORD: "your password"
- URL: jdbc:mysql://xxxx:yyyy/kkkk?serverTimezone=UTC , where:
    * xxxx - host name,
    * yyyy - port,
    * kkkk - database name

**3.** Run project
