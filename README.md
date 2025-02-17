This project does database operations that an university needs and provides a Web API to access them. The schema of the database is given below:

<img width="524" alt="databaseSchema" src="https://github.com/user-attachments/assets/8911874b-b334-47d7-861f-5d79dd83d55c" />

This project consists of 8 microservices. Microservices and their endpoints are explained below. To explain and test project well test data has been added. "[]" means that request parameter is optional

```
1) StudentGetService
      /api/get/students/all
      /api/get/students?cid={citizenId}
      /api/get/students/{id}
      /api/get/students/departments/{department}
      /api/get/students/faculty/{faculty}
      /api/get/students/coureInstance/{id}
      /api/get/students/age/{age}
      /api/get/students/age/greater/{age}
      /api/get/students/age/less/{age}
      /api/get/students/names?fname={firstName}...
```
