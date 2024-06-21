# AuctionApp - Backend

//TODO The goal is to promote collaboration. The readme should enable a developer to set up their environment and know how to integrate with your team.

//TODO Without the provided template it will be difficult for you to produce the document I expect.


## Description

//TODO The purpose of this description is to describe the application's objective. It should have a business-oriented focus.

This project is a Java Spring Boot web application that provides a RESTful API to manage auction sales.

The application includes the following features:

- CRUD operations for categories and lots
- Exception management for entities not found
- Initial data loading
- Initialization of test users

## File Structure
//TODO tree /f. This will give you the "visual" structure and you will just need to comment on the diagram.

The project is composed of the following files:

### Configuration
- **CorsConfig.java** : CORS configuration to allow cross-origin requests.

### Controllers
- **CategoryController.java** : Manages HTTP requests for categories.
- **LotController.java** : Manages HTTP requests for lots.
- **UserController.java** : Manages HTTP requests for users.

### Models
- **Category.java** : Represents the Category entity.
- **Lot.java** : Represents the Lot entity.
- **User.java** : Represents the User entity.

### Repositories
- **CategoryRepository.java** : Interface for category data access.
- **LotRepository.java** : Interface for lot data access.
- **UserRepository.java** : Interface for user data access.
- **LoadDatabase.java** : Class to load initial data into the database.

### Exceptions
- **CategoryNotFoundException.java** : Custom exception for category not found.
- **LotNotFoundException.java** :  Custom exception for lot not found.
- **UserNotFoundException.java** : Custom exception for user not found.

### Advices
- **LotNotFoundAdvice.java** : Exception handler for LotNotFoundException.

### Main application
- **AuctionApp.java** : Main class to start the Spring Boot application.

### Application configuration
- **application.properties** : Configuration file for the Spring Boot application.

## How to run

//TODO It's important to deliver only the essentials. The URL is already present. Don't repeat it.
//TODO We need to know how to run it for development, but also for production deployment.

1. Clone the repository.
   ```sh
   git clone [URL du dépôt]

2. Ensure you have Java and Maven installed.
   Download Maven from this link:
   ```sh
   https://maven.apache.org/download.cgi 
   
3. Unzip the downloaded file to your desired location.
   Add the Maven bin path to your environment variables. For example:
   ```sh
   C:\Program Files\apache-maven-3.8.6\bin
3. Naviguez jusqu'au répertoire du projet
   ```sh
   cd [nom_du_répertoire choisi]
4. Navigate to the project directory
   ```sh
   mvn spring-boot:run
5. Run the AuctionApp application with the following command:
   ```sh
   run AuctionApp
   
