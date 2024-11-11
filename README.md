# Xampro Automation

This repository contains automated test cases for the **Xampro** online exam platform using **Selenium WebDriver** with **Java**. The project automates core functionalities like user registration(not implemented), login, profile update.

## Features
- **Automated Login**: Logs in using credentials from json file.
- **Profile Update**: Updates user profile and verifies successful updates via toast messages.
  
## Technologies Used
- **Java**: Programming language for automation.
- **Selenium WebDriver**: Browser automation tool.
- **JUnit**: Testing framework for assertions.
- **Jackson Databind**: For reading and parsing JSON files.
- **Maven**: Dependency management and build tool.

## Prerequisites
Before you start, ensure you have the following installed:
- **Java JDK** (version 8 or higher)
- **Apache Maven** (version 3.6.3 or higher)
- WebDriver binaries for the browsers (ChromeDriver, GeckoDriver, etc.)
- An IDE like **Eclipse**
  
### Project Structure
```bash
xampro-automation/
├── src/
│   ├── main/
│   │   └── java/
│   └── test/
│       └── java/
│           └── java/automation
│                     ├── login.java
│                     ├── ProfileUpdate.java
│                     └── users.json
├── pom.xml
└── README.md
```
## Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/mimakte/xampro-automation.git
cd xampro-automation
```

### 2. Open the folder in Eclipse IDE

### 3. In Eclipse, Right Click on the Project -> Maven -> Update Project. It will install the dependecies mentioned in pom.xml file

### 4. Run a particular test file
 
