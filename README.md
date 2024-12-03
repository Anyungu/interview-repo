## Task Management Application

## Prerequisites
Before deploying and running the application, ensure you have the following:

Java Development Kit (JDK): Version 17 or higher.
Maven: Version 3.8.0 or higher.
Database: H2 (in-memory) or any compatible database (PostgreSQL, MySQL, etc.).
Git: Version control system for cloning the repository.

1. Clone the Repository
bash
Copy code
git clone <repository-url>
cd <repository-folder>

2. Configure the Application
Locate the application.properties or application.yml file in the src/main/resources directory.
Update the database configuration (if not using H2):


1. Build the Application
Use Maven to build the application:

bash
Copy code
mvn clean install
4. Run the Application
Start the application using Maven or the generated JAR file:

bash
Copy code
# Option 1: Run directly with Maven
mvn spring-boot:run

# Option 2: Run the generated JAR file
java -jar target/task-management-app-0.0.1-SNAPSHOT.jar
5. Access the Application
The application will be accessible at:

http://localhost:8080
http://localhost:8080/swagger-ui/index.html
