# user's-information-application API Documantation

### `Version`: 1.0.0
### `Date`: 2021-10-06
user's-information-application will expose several APIs.Here I have used Swagger for API Documentation.Let's go to:- 
The endpoints are:
API Documentation are here: `url`:http://localhost:8083/swagger-ui.html
#### 1. When triggered with a Request Body of RequestPayload Object it stores User's information either it is parent type or child type: For Parent Type user.To do that, click on  
`request-payload-rest-controller`: 
#### Try with POST 
Click on `Try it out` then copy the sample request body and paste on payload's request body then execute



`Request-body`:
```            
{
"firstName":"Hasnain",
"lastName":"khan",
"email":"hasnain@yopmail.com",
"child":false,
  "address": {
    "state": "Newyork",
    "city": "Albany",
    "zip": "11021",
    "street": "12"
}
}
```
`Content-Type`:
application/json

If added successfully,

`Demo Response Body` :
`{
"id": 1,
"address": {
  "id": 2,
  "state": "Newyork",
  "city": "Albany",
  "zip": "11021",
  "street": "12"
},
"user": {
  "id": 1,
  "firstName": "Hasnain",
  "lastName": "khan",
  "email": "hasnain@yopmail.com"
}
}`

If already exists with same email ,

`Demo Response Body` :
`{
"status": "BAD_REQUEST",
"message": "This  Email has been already used.Try again with another email"
}`

If First Name  or Email input values are null

`Demo Response` :
`{
"status": "BAD_REQUEST",
"message": "Email and First Name both should be given"
}`
If Address's State input is null
`Demo Response` :
`{
"status": "BAD_REQUEST",
"message": "STATE IS MISSING"
}`
##Child Type User:
`method`: POST

`Content-Type`:
application/json

`Sample Request-body`:
```            
{
"firstName":"Tahmid",
"lastName":"khan",
"email":"tahmid@yopmail.com",
"child":true,
 "address": {
  "state": "Haowi",
  "city": "Albany",
  "zip": "11021",
  "street": "12"
},
"parentId":1
}
```
If added successfully,

`Demo Response` :
`{
"id": 4,
"parentId": 1,
 "user": {
  "id": 4,
  "firstName": "Tahmid",
  "lastName": "khan",
  "email": "tahmid@yopmail.com"
 }
}`

If parent id is null ,

`Demo Response` :
`{
"status": "BAD_REQUEST",
"message": "This user's parent id is missing!"
}`
If already exists with same email ,

`Demo Response` :
`{
"status": "BAD_REQUEST",
"message": "This  Email has been already used.Try again with another email"
}`

If First Name  or Email input values are null

`Demo Response` :
`{
"status": "BAD_REQUEST",
"message": "Email and First Name both should be given"
}`


### 2. /To see the user's list
Go to:-  `User Controller-GET (getAllUsers)`  try it out

#### 1. When triggered it returns List of users(parent & child) already stored in Database.
`method` :
GET
`request url`:http://localhost:8083/api/v1/users
`Content-Type`:
application/json

`Demo Response` :
```
 [
    {
        "userId": 1,
        "firstName": "Tahmid",
        "lastName": "khan",
        "email": "tahmids@yopmail.com",
        "child": false,
        "parentId": null,
        "address": {
            "id": 2,
            "state": "Haowi",
            "city": "Albany",
            "zip": "11021",
            "street": "12"
        }
    },
    {
        "userId": 3,
        "firstName": "Hasnain",
        "lastName": "khan",
        "email": "hasnain@yopmail.com",
        "child": false,
        "parentId": null,
        "address": null
    }
]

```

### 2. Get User (id)
#### 1. When triggered it shows detail about the user with given user ID from Database. Try it out
`method` :
GET
`request url`:http://localhost:8083/api/v1/users/1

provide `id` on id parameter :1 (For Example) the click on Execute

`Demo Response` :
`{
"id": null,
"userId": 1,
"firstName": "Hasnain",
"lastName": "khan",
"email": "hasnain@yopmail.com",
"child": false,
"parentId": null,
"address": {
"id": 2,
"state": "Newyork",
"city": "Albany",
"zip": "11021",
"street": "12"
}
}`


If there is wrong id provided

`Demo Response` :
`{
"status": "NOT_FOUND",
"message": "This  User is Not Available"
}`


#### 3. To Update User's Information go to request-pay-load-controller->PUT


`method`: PUT

`Content-Type`:
application/json

`Request-body`:
```            
{
"userId":1,
"firstName":"Hussain",
"lastName":"Ahmed",
"email":"hasnainahmed@yopmail.com",
  "address": {
    "state": "Newyork Port City",
    "city": "Albany",
    "zip": "11021",
    "street": "12"
}
}
```
If updated successfully

`Demo Response`:
`{
"id": 1,
"address": {
"id": 2,
"state": "Newyork Port City",
"city": "Albany",
"zip": "11021",
"street": "12"
},
"user": {
"id": 1,
"firstName": "Hussain",
"lastName": "Ahmed",
"email": "hasnain@yopmail.com"
}
}`
If the given userId is null

`Demo Response`: `{
"status": "BAD_REQUEST",
"message": "User Id is missing! Please provide userId's valid value"
}`

If the given id is invalid

`Demo Response`: `{
"status": "NOT_FOUND",
"message": "User Not Found with this userId"
}`

### 3. /USER DELETE

#### 1. When triggered it returns List of childs already stored in Database.
`method` :
DELETE

`Content-Type`:
application/json

`Demo Response` :
```
Server Response 200
```
#### 2. When try to delete with wrong ID

`Dem -Response`:
```            
{
  "status": "NOT_FOUND",
  "message": "This  User is Not Available"
}
```


### 4. / DELETE CHILD USER

#### 1. When triggered it deletes child type user.
`method` :
DELETE

`Content-Type`:
application/json

`Demo Response` :
```
Server Response 200
```
#### 2. When try to delete with wrong ID

`Dem -Response`:
```            
{
  "status": "NOT_FOUND",
  "message": "This  User is Not Available"
}
```