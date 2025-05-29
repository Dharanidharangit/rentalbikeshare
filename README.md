# 🚲 Bike Rental Management System

A full-featured **Spring Boot REST API** for managing bike rentals. This application includes modules for user registration and login, bike inventory management, rental booking and return, and CRUD operations for users and bikes.

---

## 🔧 Technologies Used

- Java 17  
- Spring Boot 3  
- Spring Data JPA  
- Hibernate  
- MySQL  
- Maven  
- REST APIs  

---

## 📁 Project Structure

src/
├── main/
│ ├── java/com/sampleproject/sampleproject/
│ │ ├── controllers/
│ │ ├── entity/
│ │ ├── repository/
│ │ ├── service/
│ │ └── SampleprojectApplication.java
│ └── resources/
│ ├── application.properties


👤 User APIs
Method	Endpoint	Description
POST	/api/Userregister	Register a new user
POST	/api/Userlogin	User login
GET	/api/getusers	Get all users
GET	/api/getusersbyid/{userid}	Get user by ID
PUT	/api/update/{userid}	Update user by ID
DELETE	/api/deleteuserbyid/{userid}	Delete user by ID

🚴 Bike APIs
Method	Endpoint	Description
POST	/api/bikeadd	Add a new bike
PUT	/api/updatebike/{bikeid}	Update bike by ID
GET	/api/getdatabybikeid/{bikeid}	Get bike details by ID
GET	/api/getallbikes	Get all bikes
DELETE	/api/Deletebike/{bikeid}	Delete bike by ID

📄 Rental APIs
Method	Endpoint	Description
POST	/api/rentalbooking	Book a bike rental
POST	/api/bikereturn/{rentalid}	Return a rented bike
GET	/api/Getallrentalrecords	Get all rental records
GET	/api/rentalhistoryforspecificuser/{userid}	Rental history for a user
DELETE	/api/deleterentalrecordbyuserid/{userid}	Delete rentals by user ID

🧪 Sample JSON Requests
Register a User
json
Copy
Edit
POST /api/Userregister
{
  "username": "john123",
  "password": "securepass",
  "email": "john@example.com"
}
Add a Bike
json
Copy
Edit
POST /api/bikeadd
{
  "bikename": "Yamaha FZ",
  "rent": 250.0,
  "status": "available"
}
Book a Rental
json
Copy
Edit
POST /api/rentalbooking
{
  "userid": 1,
  "bikeid": 2,
  "startdate": "2025-05-01",
  "enddate": "2025-05-03"
}
📝 Notes
Use tools like Postman or cURL for testing endpoints.

Make sure your MySQL database is running.

Use @Transactional in service methods when performing delete operations using custom repository methods.
