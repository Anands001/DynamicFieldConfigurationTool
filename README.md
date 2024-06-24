---

# Dynamic Field Configuration Tool

![Dynamic Field Configuration Tool](https://img.shields.io/badge/Version-1.0.0-brightgreen)

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Architecture](#architecture)
- [Screenshots](#screenshots)
- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Introduction
The **Dynamic Field Configuration Tool** is designed to provide developers with the ability to configure server-side data validation rules dynamically. This tool aims to streamline the validation process by allowing validation rules to be modified without requiring code changes, enhancing flexibility and reducing maintenance overhead.

## Features
- **Dynamic Validation Rule Configuration**: Easily configure validation rules for various data fields.
- **Real-Time Validation**: Apply validation rules in real-time to ensure data integrity.
- **User-Friendly Interface**: Intuitive web-based interface for managing validation rules.
- **Integration with Server-Side Projects**: Seamless integration with existing server-side projects.
- **API Access**: Expose validation functionalities via RESTful APIs.

## Architecture
The tool is built using a Model-View-Controller (MVC) architecture, ensuring a clear separation of concerns and facilitating maintainability.

- **Frontend**: Built with HTML, CSS, and JavaScript.
- **Backend**: Developed using Spring Boot for handling business logic and RESTful API.
- **Database**: Uses a relational database for storing validation rules and metadata.

![Architecture diagram](https://github.com/Anands001/DynamicFieldConfigurationTool/assets/110816114/3510d20a-c2e9-48fa-8a2d-32effeddb289)


## Screenshots
**Home Page**
![Home Page](https://github.com/Anands001/DynamicFieldConfigurationTool/assets/110816114/661cb7fc-5f3f-4f40-bc84-11fa0b066413)


**Validation Rule Configuration**
![Validation Rule Configuration](https://github.com/Anands001/DynamicFieldConfigurationTool/assets/110816114/35125e73-7c4b-4d9d-8a5a-9e666cf29427)


## Installation

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Apache Maven
- Git
- Web Browser (e.g., Chrome, Firefox)

### Steps
1. **Clone the Repository:**
   ```bash
   git clone https://github.com/Anands001/DynamicFieldConfigurationTool.git
   ```
2. **Navigate to the Project Directory:**
   ```bash
   cd DynamicFieldConfigurationTool
   ```
3. **Install Dependencies:**
   ```bash
   mvn install
   ```
4. **Run the Application:**
   ```bash
   mvn spring-boot:run
   ```
5. **Access the Tool:**
   Open a web browser and navigate to `http://localhost:9090`.

## Usage
1. **Configure Validation Rules:**
   - Navigate to the validation rule configuration page.
   - Select the entity and field to configure.
   - Define validation rules and save changes.

2. **Integrate with Server-Side Projects:**
   - Use the provided API endpoints to send data for validation.
   - Receive validation feedback and handle errors accordingly.

## API Endpoints

### Authentication
- **POST** `/login`: Authenticate user and receive a token.

### Validation Rules
- **POST** `/configureValidation`: Configure validation rules for specific fields.
- **GET** `/getValidationRules`: Retrieve existing validation rules.

### Data Validation
- **POST** `/checkValidation`: Validate data against configured rules.

### Example Request
```http
POST /checkValidation
Host: localhost:9090
Content-Type: application/json
{
  "entity": "Student",
  "data": {
    "name": "John Doe",
    "email": "john@example.com",
    "age": 22
  }
}
```

### Example Response
```json
{
  "status": "success",
  "errors": []
}
```

## Testing

### Unit Testing
Tests individual components to ensure they function correctly in isolation.
- Validate rule configuration functionality.
- Test authentication mechanisms.

### Integration Testing
Verifies the integration of different modules within the tool.
- Test frontend-backend integration.
- Test database interactions.

### Running Tests
Use Postman to run API tests and verify functionality.
- Import the provided Postman collection.
- Run tests and review results.

```bash
newman run "DynamicFieldValidation.postman_collection.json" -r html,cli
```

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact
For any questions or support, please contact:
- **Anand S.** - [sssanand70@gmail.com](mailto:sssanand70@gmail.com)
- GitHub: [Anands001](https://github.com/Anands001)

---
