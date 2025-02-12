# Micronaut Java JPA H2 Example

This project demonstrates a basic example of using **Micronaut Framework** with **Java**, **JPA (Java Persistence API)**, and an **H2 in-memory database**.

---

## **Features**
- **Micronaut Framework**: A modern JVM-based framework for building modular, lightweight applications.
- **JPA with Hibernate**: For object-relational mapping (ORM).
- **H2 Database**: A lightweight, in-memory database for rapid development and testing.

---

## **Developer Setup Instructions**

### **Prerequisites**
Ensure you have the following installed on your system:
1. **Java 21 or later**
    - Download and install [Java](https://adoptopenjdk.net/).
    - Verify installation:
      ```bash
      java -version
      ```

2. **Micronaut CLI (Optional)**
    - Install via SDKMAN (recommended):
      ```bash
      sdk install micronaut
      ```
    - Verify installation:
      ```bash
      mn --version
      ```

3. **Gradle** (If not bundled with the project)
    - Install Gradle or use the Gradle wrapper included in the project (`./gradlew`).
    - Verify installation:
      ```bash
      gradle -v
      ```

---

### **Steps to Set Up Locally**

#### 1. **Clone the Repository**
Clone the repository to your local machine:
   ```bash
   git clone https://github.com/niteshsinghrajput/micronaut-java-jpa-h2.git
   cd micronaut-java-jpa-h2
   ```

#### 2. **Build the Project**
Build the project using the Gradle wrapper:
   ```bash
   ./gradlew build
   ```

If Gradle is installed globally, you can use:
   ```bash
   gradle build
   ```

#### 3. **Run the Application**
Start the Micronaut application:
   ```bash
   ./gradlew run
   ```

Or, if Gradle is installed globally:
   ```bash
   gradle run
   ```

#### 4. **Access the Application**
By default, the application runs on port **8080**. You can access it at:
   ```
   http://localhost:8080
   ```

---

### **Testing the Application**

#### 1. **Run Unit Tests**
To execute the test suite:
   ```bash
   ./gradlew test
   ```

Or:
   ```bash
   gradle test
   ```

#### 2. **API Testing**
- Use a tool like **Postman**, **curl**, or a browser to interact with the APIs.
- Example:
  ```bash
  curl -X GET http://localhost:8080/users
  ```

---

### **Project Structure**
- **`src/main/java`**: Contains application code.
- **`src/test/java`**: Contains unit tests.
- **`application.yml`**: Configuration file for the application.
- **`build.gradle`**: Gradle build configuration.


### Usage

Once the application is running, you can access the API endpoints using a tool like Postman or cURL.

The API supports the following endpoints:

### **1. Create a New User (POST)**
To create a new user, you do **not** need to provide the `id`. Here's the `curl` command:

```bash
curl -X POST http://localhost:8080/users \
-H "Content-Type: application/json" \
-d '{
	"name": "Nitesh Rajput",
	"contact": "8553977672",
	"email": "nitesh.rajput@gmail.com"
}'
```

#### Example Response:
```json
{
	"id": 1,
	"name": "Nitesh Rajput",
	"contact": "8553977672",
	"email": "nitesh.rajput@gmail.com",
	"createdAt": "2025-01-05T15:02:27.787697"
}
```

---

### **2. Retrieve a User by ID (GET)**
To retrieve a user by their ID (e.g., `2`):

```bash
curl -X GET http://localhost:8080/users/2
```

#### Example Response:
```json
{
	"id": 2,
	"name": "Nitesh Rajput",
	"contact": "8553977672",
	"email": "rajput.nitesh012@gmail.com",
	"createdAt": "2025-01-05T15:02:27.787697"
}
```

---

### **3. Retrieve All Users (GET)**
To retrieve all users:

```bash
curl -X GET http://localhost:8080/users
```

#### Example Response:
```json
[
	{
		"id": 1,
		"name": "Nitesh Rajput",
		"contact": "8553977672",
		"email": "rajput.nitesh012@gmail.com",
		"createdAt": "2025-01-05T15:02:27.787697"
	},
	{
		"id": 2,
		"name": "John Doe",
		"contact": "9876543210",
		"email": "john.doe@example.com",
		"createdAt": "2025-01-05T16:30:00.000000"
	}
]
```

---

### **4. Update a User by ID (PUT)**
To update an existing user (e.g., `id=2`), use:

```bash
curl -X PUT http://localhost:8080/users/2 \
-H "Content-Type: application/json" \
-d '{
	"name": "Nitesh Singh Rajput",
	"contact": "8553977672",
	"email": "rajput.nitesh012t@gmail.com"
}'
```

#### Example Response:
```json
{
	"id": 2,
	"name": "Nitesh Singh Rajput",
	"contact": "8553977672",
	"email": "rajput.nitesh012@gmail.com",
	"createdAt": "2025-01-05T15:02:27.787697"
}
```

---

### **5. Delete a User by ID (DELETE)**
To delete a user by their ID (e.g., `2`):

```bash
curl -X DELETE http://localhost:8080/users/2
```

#### Example Response:
```json
{
	"message": "User with ID 2 has been deleted successfully."
}
```

---

### Exception Handling Scenarios:

---

### **1. Retrieve a Non-Existent User (404 Not Found)**

If you try to retrieve a user with an ID that does not exist (e.g., `id=999`), the server will return a `404 Not Found` error.

#### Example `curl` Command:
```bash
curl -X GET http://localhost:8080/users/999
```

#### Example Response:
```json
{
	"error": "User not found",
	"details": "User with ID 999 does not exist."
}
```

---

### **2. Create a User with Invalid Data (400 Bad Request)**

If you attempt to create a user but omit required fields (e.g., `name`), the server will return a `400 Bad Request` error.

#### Example `curl` Command:
```bash
curl -X POST http://localhost:8080/users \
-H "Content-Type: application/json" \
-d '{
	"contact": "8553977672",
	"email": "nitesh.rajput@gmail.com"
}'
```

#### Example Response:
```json
{
	"error": "Invalid request data",
	"details": "Field 'name' is required."
}
```

---

### **3. Update a Non-Existent User (404 Not Found)**

If you try to update a user that doesn’t exist (e.g., `id=999`), you’ll get a `404 Not Found` error.

#### Example `curl` Command:
```bash
curl -X PUT http://localhost:8080/users/999 \
-H "Content-Type: application/json" \
-d '{
	"name": "Nitesh Singh Rajput",
	"contact": "8553977672",
	"email": "nitesh.singh.rajput@gmail.com"
}'
```

#### Example Response:
```json
{
	"error": "User not found",
	"details": "Cannot update user with ID 999 because it does not exist."
}
```

---

### **4. Delete a Non-Existent User (404 Not Found)**

Trying to delete a user that doesn’t exist will result in a `404 Not Found` error.

#### Example `curl` Command:
```bash
curl -X DELETE http://localhost:8080/users/999
```

#### Example Response:
```json
{
	"error": "User not found",
	"details": "User with ID 999 does not exist."
}
```

---

### **5. Invalid Request Format (400 Bad Request)**

If the request JSON payload is malformed, the server will return a `400 Bad Request` error.

#### Example `curl` Command:
```bash
curl -X POST http://localhost:8080/users \
-H "Content-Type: application/json" \
-d '{
	"name": "Nitesh Rajput",
	"contact": 8553977672, # Invalid data type
	"email": "nitesh.rajput@gmail.com"
}'
```

#### Example Response:
```json
{
	"error": "Malformed JSON request",
	"details": "Invalid data type for field 'contact'. Expected string but got number."
}
```

---

### **6. Unsupported HTTP Method (405 Method Not Allowed)**

If you use an unsupported HTTP method (e.g., `PATCH`), the server will return a `405 Method Not Allowed` error.

#### Example `curl` Command:
```bash
curl -X PATCH http://localhost:8080/users/2 \
-H "Content-Type: application/json" \
-d '{
	"name": "Updated Name"
}'
```

#### Example Response:
```json
{
	"error": "Method not allowed",
	"details": "HTTP method PATCH is not supported for this endpoint."
}
```

### **Contributing**
If you’d like to contribute:
1. Fork the repository.
2. Create a feature branch.
3. Commit your changes and push to your fork.
4. Open a pull request.

---

### **License**
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## Micronaut 4.7.3 Documentation

- [User Guide](https://docs.micronaut.io/4.7.3/guide/index.html)
- [API Reference](https://docs.micronaut.io/4.7.3/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/4.7.3/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

- [Shadow Gradle Plugin](https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow)
- [Micronaut Gradle Plugin documentation](https://micronaut-projects.github.io/micronaut-gradle-plugin/latest/)
- [GraalVM Gradle Plugin documentation](https://graalvm.github.io/native-build-tools/latest/gradle-plugin.html)
## Feature serialization-jackson documentation

- [Micronaut Serialization Jackson Core documentation](https://micronaut-projects.github.io/micronaut-serialization/latest/guide/)


## Feature micronaut-aot documentation

- [Micronaut AOT documentation](https://micronaut-projects.github.io/micronaut-aot/latest/guide/)


## Feature jdbc-hikari documentation

- [Micronaut Hikari JDBC Connection Pool documentation](https://micronaut-projects.github.io/micronaut-sql/latest/guide/index.html#jdbc)


