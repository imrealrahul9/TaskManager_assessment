TaskManager Backend

This is a Spring Boot application designed to manage tasks. It includes features such as task creation, task assignment to users.

Features

CRUD operations for tasks and users.
RESTful API integration.
Timezone handling for task creation.
Requirements

Java 17+
Maven 3+
PostgreSQL (or any preferred database)
Setup Instructions

1. Clone the Repository

2. Database Configuration
Ensure PostgreSQL is running locally or on a server.
Create a PostgreSQL database for the project. For example: CREATE DATABASE taskmanager_db;
Update the application.properties file located in src/main/resources/ with your database credentials.

3. API Endpoints
Here are the primary endpoints for the task management system:

1. Create Task

URL: /api/tasks
Method: POST
Body: JSON

2. Get Tasks

URL: /api/tasks
Method: GET

3.Get Tasks by id

URL: /api/tasks/{id}
Method: GET

3. Update Task

URL: /api/tasks/{id}
Method: PUT
Body: JSON

4. Delete Task

URL: /api/tasks/{taskId}
Method: DELETE






