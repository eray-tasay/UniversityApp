This project does database operations that an university needs and provides a Web API to access them. The schema of the database is given below:

<img width="524" alt="databaseSchema" src="https://github.com/user-attachments/assets/8911874b-b334-47d7-861f-5d79dd83d55c" />

This project consists of 8 microservices. Microservices and their endpoints are explained below. To explain and test project well test data has been added. 
Note that some test data may seem unreleated to the domain. "[]" means that request parameter is optional.
```
1) StudentGetService

/api/get/students/all
/api/get/students?cid={citizenId}
/api/get/students/{id}
/api/get/students/departments/{department}[?fname={facultyName}]: Gets all students of given department.
/api/get/students/faculty/{faculty}: Gets all students of given faculty.
/api/get/students/coureInstance/{id}: Gets all students who enroll given course instance.
/api/get/students/age/{age}
/api/get/students/age/greater/{age}
/api/get/students/age/less/{age}
/api/get/students/names?fname={firstName}[&mname={middleName}]&lname={lastName}
```
```
/api/get/students/all

{
    "students": [
        {
            "id": 1,
            "fullName": "Kaine Urbanus Humpherston",
            "email": "uhumpherston0@mysql.com",
            "citizenId": "13914085570",
            "birthDate": "2002-09-09",
            "departments": [
                "Architecture"
            ]
        },
        {
            "id": 2,
            "fullName": "Gunar Thaxter Roeby",
            "email": "troeby1@de.vu",
            "citizenId": "29658261139",
            "birthDate": "1995-10-25",
            "departments": [
                "Architecture",
                "Chemical Engineering",
                "Nuclear Science and Engineering",
                "Anthropology",
                "Chemistry"
            ]
        }, ...
    ]
}
```
```
/api/get/students?cid=65346923301

{
    "id": 120,
    "fullName": "Hildy Trenna Cellier",
    "email": "tcellier3b@census.gov",
    "citizenId": "65346923301",
    "birthDate": "1999-09-04",
    "departments": [
        "Music and Theater Arts",
        "Science, Technology, and Society",
        "Biology",
        "Chemistry"
    ]
}
```
```
/api/get/students/150

{
    "id": 150,
    "fullName": "Dani Rosie Long",
    "email": "rlong45@biglobe.ne.jp",
    "citizenId": "64021078327",
    "birthDate": "1997-09-17",
    "departments": [
        "Architecture",
        "Physics"
    ]
}
```
```
/api/get/students/departments/Chemistry

{
    "students": [
        {
            "id": 2,
            "fullName": "Gunar Thaxter Roeby",
            "email": "troeby1@de.vu",
            "citizenId": "29658261139",
            "birthDate": "1995-10-25",
            "departments": [
                "Architecture",
                "Chemical Engineering",
                "Nuclear Science and Engineering",
                "Anthropology",
                "Chemistry"
            ]
        },
        {
            "id": 58,
            "fullName": "Pandora Cybil Jeannaud",
            "email": "cjeannaud1l@dell.com",
            "citizenId": "83720557910",
            "birthDate": "2003-09-05",
            "departments": [
                "Humanities + Engineering/Science",
                "Chemistry"
            ]
        }, ...
    ]
}
```
```
/api/get/students/faculty/Science

{
    "students": [
        {
            "id": 37,
            "fullName": "Abba Vaughan Ollerhad",
            "email": "vollerhad10@thetimes.co.uk",
            "citizenId": "45677034415",
            "birthDate": "2002-12-07",
            "departments": [
                "Mechanical Engineering",
                "Biology",
                "Nuclear Science and Engineering"
            ]
        },
        {
            "id": 73,
            "fullName": "Stan Brooks Casero",
            "email": "bcasero20@mit.edu",
            "citizenId": "43449499705",
            "birthDate": "1995-07-23",
            "departments": [
                "Electrical Engineering and Computer Science",
                "Biology",
                "Chemistry",
                "Comparative Media Studies/Writing"
            ]
        }, ...
    ]
}
```
```
/api/get/students/courseInstance/1

{
    "students": [
        {
            "id": 469,
            "fullName": "Mikkel Ennis Dandy",
            "email": "edandyd0@github.com",
            "citizenId": "77844302950",
            "birthDate": "1999-03-05",
            "departments": [
                "Comparative Media Studies/Writing"
            ]
        },
        {
            "id": 472,
            "fullName": "Dulci Dyna Thumann",
            "email": "dthumannd3@google.co.uk",
            "citizenId": "96365411891",
            "birthDate": "2000-04-07",
            "departments": [
                "Economics",
                "Literature",
                "Anthropology",
                "Comparative Media Studies/Writing"
            ]
        },
        {
            "id": 970,
            "fullName": "Ulberto Steagall",
            "email": "usteagalld1@networkadvertising.org",
            "citizenId": "17188098495",
            "birthDate": "1996-01-22",
            "departments": [
                "Economics",
                "Music and Theater Arts",
                "Computer Engineering",
                "Nuclear Science and Engineering"
            ]
        }
    ]
}
```
```
/api/get/students/age/23

{
    "students": [
        {
            "id": 13,
            "fullName": "Kaitlynn Netty Oliff",
            "email": "noliffc@mac.com",
            "citizenId": "20001534680",
            "birthDate": "2001-08-03",
            "departments": [
                "Physics",
                "Electrical Engineering and Computer Science"
            ]
        },
        {
            "id": 31,
            "fullName": "Harwell Joana MacGahy",
            "email": "jmacgahyu@archive.org",
            "citizenId": "52722667654",
            "birthDate": "2001-11-06",
            "departments": [
                "Media Arts and Sciences",
                "Biological Engineering",
                "Linguistics"
            ]
        }, ...
    ]
}
```
```
/api/get/students/age/greater/28

{
    "students": [
        {
            "id": 2,
            "fullName": "Gunar Thaxter Roeby",
            "email": "troeby1@de.vu",
            "citizenId": "29658261139",
            "birthDate": "1995-10-25",
            "departments": [
                "Architecture",
                "Chemical Engineering",
                "Nuclear Science and Engineering",
                "Anthropology",
                "Chemistry"
            ]
        },
        {
            "id": 6,
            "fullName": "Aubrie Jeralee Aves",
            "email": "javes5@networkadvertising.org",
            "citizenId": "67645781755",
            "birthDate": "1995-09-08",
            "departments": [
                "History"
            ]
        }, ...
    ]
}
```
```
/api/get/students/age/less/21

{
    "students": [
        {
            "id": 17,
            "fullName": "Bron Krissie Towner",
            "email": "ktownerg@home.pl",
            "citizenId": "19758323580",
            "birthDate": "2004-10-08",
            "departments": []
        },
        {
            "id": 56,
            "fullName": "Stepha Elsy MacNamee",
            "email": "emacnamee1j@marketwatch.com",
            "citizenId": "68809085472",
            "birthDate": "2004-08-21",
            "departments": [
                "History",
                "Urban Studies and Planning",
                "Mechanical Engineering"
            ]
        }, ...
    ]
}
```
```
/api/get/students/names?fname=Jessie&lname=Norgate

{
    "students": [
        {
            "id": 1000,
            "fullName": "Jessie Norgate",
            "email": "jnorgatedv@ucoz.ru",
            "citizenId": "63741525275",
            "birthDate": "2004-03-31",
            "departments": [
                "Aeronautics and Astronautics",
                "Nuclear Science and Engineering"
            ]
        }
    ]
}
```
```
2) StudentPostService

Students can be added either specifing department name or department id.

/api/post/students/department/name
/api/post/students/department/id
```
```
curl -X POST http://localhost:8081/api/post/students/department/name \
-H "Content-Type: application/json" \
-d '{
    "firstName": "John",
    "middleName": "Michael",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "citizenId": "123456789",
    "birthDate": "2000-01-01",
    "departments": ["Biological Engineering", "Economics"]
}'
```
```
curl -X POST http://localhost:8081/api/post/students/department/id \
-H "Content-Type: application/json" \
-d '{
    "firstName": "Eray",
    "lastName": "Taşay",
    "email": "eray.tasay@example.com",
    "citizenId": "123456781",
    "birthDate": "2003-06-20",
    "departments": [1, 3]
}'
```
```
3) LecturerGetService

/api/get/lecturers/all
/api/get/lecturers?cid={citizenId}
/api/get/lecturers/{id}
```
```
/api/get/lecturers/all

{
    "lecturers": [
        {
            "id": 1,
            "firstName": "Tadeo",
            "middleName": "Brandea",
            "lastName": "Whebell",
            "citizenId": "27055437892",
            "email": "bwhebell0@arizona.edu",
            "birthDate": "22/06/1994",
            "departments": [
                "Media Arts and Sciences",
                "Biological Engineering"
            ]
        },
        {
            "id": 2,
            "firstName": "Ashbey",
            "middleName": "Carolynn",
            "lastName": "McGuigan",
            "citizenId": "45623223792",
            "email": "cmcguigan1@businessinsider.com",
            "birthDate": "08/04/1994",
            "departments": [
                "Humanities + Engineering/Science"
            ]
        }, ...
    ]
}
```
```
/api/get/lecturers?cid=53802467129

{
    "id": 91,
    "firstName": "Roseann",
    "lastName": "Yeeles",
    "citizenId": "53802467129",
    "email": "ryeeles14@myspace.com",
    "birthDate": "24/11/1994",
    "departments": [
        "Chemistry"
    ]
}
```
```
/api/get/lecturers/18

{
    "id": 18,
    "firstName": "Mirna",
    "middleName": "Reynard",
    "lastName": "Naris",
    "citizenId": "56594192404",
    "email": "rnarish@ycombinator.com",
    "birthDate": "08/10/1994",
    "departments": [
        "Chemical Engineering",
        "Civil and Environmental Engineering",
        "Management"
    ]
}
```
```
4) LecturerPostService

Lecturers can be added either specifing department name or department id.

/api/post/lecturers/department/id
/api/post/lecturers/department/name
```
```
curl -X POST http://localhost:8083/api/post/lecturers/department/name \
-H "Content-Type: application/json" \
-d '{
    "firstName": "John",
    "middleName": "Michael",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "citizenId": "123456789",
    "birthDate": "2000-01-01",
    "departments": ["Biological Engineering", "Economics"]
}'
```
```
curl -X POST http://localhost:8083/api/post/lecturers/department/id \
-H "Content-Type: application/json" \
-d '{
    "firstName": "Eray",
    "lastName": "Taşay",
    "email": "eray.tasay@example.com",
    "citizenId": "123456781",
    "birthDate": "2003-06-20",
    "departments": [1, 3]
}'
```
```
5) CourseInstanceGetService

/api/get/courseInstances/student/{id}: Get all course instances enrolled by a student.
/api/get/courseInstances/lecturer/{id}: Get all course instances taught by a lecturer.
```
```
/api/get/courseInstances/student/20

{
    "courseInstances": [
        {
            "id": 171,
            "course": {
                "code": "SEZ-518",
                "name": "Heidenreich, Muller and Collier"
            },
            "lecturerFullName": "Adrea Bailie",
            "semester": {
                "year": 2019,
                "type": "SPRING"
            },
            "startTime": "17:32:00",
            "endTime": "23:11:00",
            "dayOfWeek": "FRIDAY",
            "classroom": "133"
        },
        {
            "id": 1173,
            "course": {
                "code": "PFZ-728",
                "name": "Altenwerth-Weber"
            },
            "lecturerFullName": "Chiquia Mc Trusty",
            "semester": {
                "year": 2023,
                "type": "SPRING"
            },
            "startTime": "16:52:00",
            "endTime": "22:53:00",
            "dayOfWeek": "THURSDAY",
            "classroom": "210"
        },
        {
            "id": 1135,
            "course": {
                "code": "CXK-545",
                "name": "Graham-Wilkinson"
            },
            "lecturerFullName": "Brittany Botterill",
            "semester": {
                "year": 2024,
                "type": "FALL"
            },
            "startTime": "16:35:00",
            "endTime": "03:24:00",
            "dayOfWeek": "THURSDAY",
            "classroom": "36"
        },
        {
            "id": 104,
            "course": {
                "code": "DFK-647",
                "name": "Rogahn LLC"
            },
            "lecturerFullName": "Ned Cookie Havill",
            "semester": {
                "year": 2025,
                "type": "FALL"
            },
            "startTime": "22:53:00",
            "endTime": "07:14:00",
            "dayOfWeek": "WEDNESDAY",
            "classroom": "48"
        },
        {
            "id": 1629,
            "course": {
                "code": "VHJ-893",
                "name": "Volkman Group"
            },
            "lecturerFullName": "Dimitry Minni Hateley",
            "semester": {
                "year": 2023,
                "type": "SPRING"
            },
            "startTime": "13:43:00",
            "endTime": "22:43:00",
            "dayOfWeek": "TUESDAY",
            "classroom": "239"
        }
    ]
}
```
```
/api/get/courseInstances/lecturer/11

{
    "courseInstances": [
        {
            "id": 219,
            "course": {
                "code": "HMU-129",
                "name": "Hauck Group"
            },
            "lecturerFullName": "Rudolf Alaine Earpe",
            "semester": {
                "year": 2023,
                "type": "SPRING"
            },
            "startTime": "22:48:00",
            "endTime": "21:19:00",
            "dayOfWeek": "WEDNESDAY",
            "classroom": "192"
        },
        {
            "id": 246,
            "course": {
                "code": "ZNP-477",
                "name": "Klocko Group"
            },
            "lecturerFullName": "Rudolf Alaine Earpe",
            "semester": {
                "year": 2018,
                "type": "FALL"
            },
            "startTime": "19:56:00",
            "endTime": "20:59:00",
            "dayOfWeek": "TUESDAY",
            "classroom": "81"
        }, ...
    ]
}
```
```
6) CourseInstancePostService

/api/post/courseInstances
```
```
curl -X POST http://localhost:8086/api/post/courseInstances \
-H "Content-Type: application/json" \
-d '{
    "courseCode": "YGW-577",
    "lecturerId": 1,
    "semester": {
        "year": 2024,
        "type": "SPRING"
    },
    "classroom": "250",
    "startTime": "09:00:00",
    "endTime": "12:00:00",
    "dayOfWeek": "MONDAY"
}'
```
```
7) CourseService

/api/get/courses/all
/api/get/courses/{id}
/api/get/courses/code/{code}
/api/get/courses/name/{name}
/api/post/courses
```
```
/api/get/courses/all

{
    "courses": [
        {
            "id": 1,
            "code": "HMK-100",
            "name": "Zieme LLC"
        },
        {
            "id": 2,
            "code": "VKS-614",
            "name": "Stracke and Sons"
        }, ...
    ]
}

```
```
/api/get/courses/20

{
    "id": 20,
    "code": "ZNP-477",
    "name": "Klocko Group"
}
```
```
/api/get/courses/code/DXZ-891

{
    "id": 10,
    "code": "DXZ-891",
    "name": "Gusikowski Group"
}
```
```
/api/get/courses/name/Crist-Quitzon

{
    "id": 162,
    "code": "SEZ-979",
    "name": "Crist-Quitzon"
}
```
```
curl -X POST http://localhost:8084/api/post/courses \
-H "Content-Type: application/json" \
-d '{
    "code": "CS-50",
    "name": "Introduction to Computer Science"
}'
```
```
8) StudentToCourseInstanceService

This service is used to associate a student with a course instance.

/api/post/studentToCourseInstances
```
```
curl -X POST http://localhost:8087/api/post/studentToCourseInstances \
-H "Content-Type: application/json" \
-d '{
    "studentId": 1,
    "courseInstanceId": 10
}'
```
