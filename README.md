<h2 align="center">
  Software Engineer project for Allegro internship
</h2>

-----------
### Comments required to configure and run the Application:
#### Download Maven dependencies
    $ mvn dependency:resolve
#### Run Tests
    $ mvn test
#### Run Application
    $ mvn spring-boot:run

### Endpoints for GET method:
- /{user}/repositories - return list consisted of all repositories and their star count
- /{user}/stars - return total stars number from all the repositories
- /{user}/languages - return sorted list of programming languages by number of occurrences in repositories

### Future extensions could be database connection with ORM, listing followers and following people with requested page size, adding HATEOAS standard