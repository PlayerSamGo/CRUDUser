##HOW TO SET UP

Before to run UserApplication main method

Download maven dependencies

Download and install Postgresql (13)

Start Postgresql

Set up database name, set up username and password according to section 

"Url connection setting" on application.properties file

Then run UserApplication main method

##DOCUMENTATION SWAGGER

After run the project you can access to the Swagger UI to test the endpoints in case

that you don't have installed postman.

http://localhost:9090/swagger-ui

## CHALLENGE

Create a microservice and expose a REST API, you can use any tools or framework.

All data should be persist in some way.
Use of Java 8 (use lambdas or streams somehow)

Create integration/Unit tests. 
The API should be able to:

Get a user by ID
Create new users (By default as Active)
Update existing users (Just update basic info (FirstName, LastName, DateOfBirth))
Delete users (Mark it as INACTIVE)
Get all users (Just show Active users)
User spec (DB Model)

ID - Unique identifier for a user

FirstName - User first name

LastName - User last name

DateOfBirth - Employee birthday and year

Status - ACTIVE or INACTIVE

Please provide your project with instructions of how to run it and in some git repository. Any questions feel free to ask.