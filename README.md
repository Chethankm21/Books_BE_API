# CRUD-Spring-Boot-MySQL - new pr

# To Run it in Local system

### 1. You can clone it from github by running following command

```
  $ git clone https://github.com/Chethankm21/Java-mysql-CRUD.git
```

### 2. Import project into eclipse
```
  File -> Import -> Maven -> Existing Maven Projects -> Browse Project from cloned location
```
### 3. Right click on project in eclipse and then Maven -> Update Projects 

### 4. Import src/main/java/resources/book.sql into MySQL database

### 5. Update database credential and other configuration into application.properties available in src/main/java/resources


```
### 6. Right click on Application.java file and run as Java Application

## Once Sprint Boot Application will be started successfully then we 
can call following Endpoints by using POSTMAN

### 7. To get list of books call following endpoint with GET Request
```
  http://localhost:8080/bookservice/books
```
### 8.To Create New Book use following url with POST Request
```
  http://localhost:8080/bookservice/books
```
### set content type as in header as `application/json`
### set request body as raw with JSON payload
```
  {
    "name": "C++",
    "author": "Nitesh",
    "publication": "Rajput Publication",
    "category": "Computer Programming",
    "pages": 1500,
    "price": 240
  }

```
### 9.To get a particular book, use following url with `GET` request type in postman
```
  http://localhost:8080/bookservice/books/<id>
```
### 10.To update Book in database, use following url with `PUT` request type in postman
```
	http://localhost:8080/bookservice/books/<id>
```
### set content type as in header as `application/json`
### set request body as raw with JSON payload

```
 {
    "name": "java",
    "author": "anil",
    "publication": "MHE Publication",
    "category": "Computer Programming",
    "pages": 1500,
    "price": 240
  }
```
### 11.To delete a particular Book from database, use following url with `DELETE` request type in postman
```
  http://localhost:8080/bookservice/books/<id>
```


#----> To Run it as a docker container

1) Maven package - it will give you the war file in target folder.
2) Docker build = it will create a image in your local by refering Dockerfile provided
3) Run the image and access it

