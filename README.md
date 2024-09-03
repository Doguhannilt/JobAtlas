
# Job Portal Application

## Overview

This project is a Job Portal application built using Spring Boot. It provides functionalities similar to job search platforms like Indeed, allowing users to create job postings, apply for jobs, and manage user profiles.

## Features

- **User Management**: Create and manage user profiles.
- **Job Postings**: Create, update, and view job postings.
- **Applications**: Users can apply for jobs and track their applications.
- **Role-Based Access**: Different access levels for users and administrators.

## Technologies Used

- **Backend**: Spring Boot
- **Database**: MongoDB
- **Security**: Spring Security
- **Password Encoding**: BCrypt (for production) / NoOpPasswordEncoder (for simplicity in this case)

## Setup and Installation

### Prerequisites

- Java 17 or higher
- MongoDB
- Maven
- IDE (e.g., IntelliJ IDEA, Eclipse)

### Clone the Repository

```bash
git clone https://github.com/yourusername/job-portal.git
cd job-portal
```

### Configure the Application

1. **MongoDB Setup**:
   Ensure MongoDB is running on your local machine or configure the application to connect to a remote MongoDB instance.

2. **Application Properties**:
   Update `src/main/resources/application.properties` with your MongoDB connection details.

   ```properties
   spring.data.mongodb.uri=mongodb://localhost:27017/jobportal
   ```

### Build and Run

1. **Build the Project**:
   Use Maven to build the project.

   ```bash
   mvn clean install
   ```

2. **Run the Application**:
   Run the Spring Boot application.

   ```bash
   mvn spring-boot:run
   ```

3. **Access the Application**:
   Open your web browser and go to `http://localhost:8080` to access the application.

## API Endpoints

### User Management

- **Create User**: `POST /users`
  - Request Body: JSON with `username`, `email`, `password`, `birth`, `location`
  - Response: Created `User` object

- **Get User by ID**: `GET /users/{id}`
  - Response: `User` object

### Job Postings

- **Create Job Posting**: `POST /jobs`
  - Request Body: JSON with `profile`, `desc`, `exp`, `techs`
  - Response: Created `Job` object

- **Get Job by ID**: `GET /jobs/{id}`
  - Response: `Job` object

- **Update Job Posting**: `PUT /jobs/{id}`
  - Request Body: JSON with `desc`, `exp`, `techs`
  - Response: Updated `Job` object

### Applications

- **Apply for Job**: `POST /applications`
  - Request Body: JSON with `userId`, `jobId`, `status`
  - Response: Created `Application` object

## Security

- **Login**: `POST /login`
  - Parameters: `username`, `password`
  - Response: Authentication token if successful

- **Logout**: `POST /logout`
  - Response: Redirect to login page with a logout message

## Development Notes

- **Password Encoding**: Currently using `NoOpPasswordEncoder` for simplicity. For production, consider using `BCryptPasswordEncoder`.
- **Error Handling**: Implement appropriate error handling and validation for a robust application.
- **Testing**: Use JUnit and Mockito for unit testing. Integrate with a testing framework for end-to-end testing.

## Contributing

Contributions are welcome! Please fork the repository, create a new branch, and submit a pull request with your changes.

