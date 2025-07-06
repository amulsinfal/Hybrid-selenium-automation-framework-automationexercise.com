# 🧪 Hybrid Selenium Automation Framework – automationexercise.com

<br><br>
<img width="1164" alt="" src="https://github.com/user-attachments/assets/14a095d8-57bd-444f-8dff-1d13bc1463f8">
<br><br>
## 📌 Project Overview
This project demonstrates my automation testing skills using Selenium WebDriver with Java as the programming language and TestNG as the testing framework. The approach reflects real-world automation practices following a Page Object Model (POM) design pattern and a hybrid test structure for scalability and maintainability.  
This repository contains a **Hybrid Selenium Automation Framework** designed to automate the e-commerce website [automationexercise.com](https://automationexercise.com). It is built using:

- **Java**
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **Page Object Model (POM)**
- **Log4j2 for logging**
- **ExtentReports for reporting**
- **Jenkins for CI/CD**

---

## 🔧 Tech Stack

| Tool / Framework | Purpose                              |
|------------------|--------------------------------------|
| Java             | Programming Language                 |
| Selenium         | Browser Automation                   |
| TestNG           | Test Management and Assertions       |
| Maven            | Dependency & Build Management        |
| POM              | Design Pattern for Maintainability   |
| Log4j2           | Logging Test Execution               |
| ExtentReports    | HTML Test Reporting with Screenshots |
| Jenkins          | CI/CD Automation                     |
| Eclipse          | IDE used for development             |

---

## 🧩 Framework Features

- **Hybrid Framework**: Combines POM, Data-Driven, and Modular frameworks
- **Page Object Model**: Clean separation of page elements and logic
- **Data-Driven Testing**: Reads data from JSON file
- **Log4j2 Integration**: Captures test logs in both console and file
- **ExtentReports**: Visual reports with screenshots on failures
- **Jenkins CI/CD**: Integrated pipeline for automated builds and test runs

---

## 📜 Project Structure : 
Following is the folder structure for this project : <br> <br>
<img width="500" alt="" src="https://github.com/user-attachments/assets/5e0cea6f-46cf-41c3-a983-8a3a8e4beca4">

---

## 📜 Dependency using in the project:
Following are the dependencies added to the pom.xml for this project :  


| # | Name |  Version |
| -------- | -------- | -------- |
| 1 | Selenium java | 4.33.0 |
| 2 | TestNG | 7.11.0 |
| 3 | log4j-api | 2.25.0 |
| 4 | log4j-core | 2.25.0 |
| 5 | Extent Reports | 5.1.1 |
| 6 | Json Simple | 1.1.1 |
<br>
<img width="670" alt="" src="https://github.com/user-attachments/assets/dcfa244f-9cf5-4e0e-bd2f-626701af6139">

---

## 📜 Design Pattern used - Page Object Model:

**Page Object Model (POM)**: Implement the POM design pattern. This pattern involves creating separate classes for each distinct page or section of the website under test.<br>

**Page Classes**: Each page class encapsulates the web elements and methods required to interact with those elements on that specific page. This separation improves code maintainability.  

Pages classes are saved under following path : "/Hybrid-selenium-automation-framework-automationexercise.com/src/main/java/com/ae/pages"  
<br>
<img width="500" alt="" src="https://github.com/user-attachments/assets/504ce273-ccac-4d8c-9482-db42ffc5e28c">

---

## 📜 Test cases :

**Test Classes:** Test classes that correspond to different test scenarios or functionalities are created. Tests classes are saved under following path : "/hybrid-selenium-automation-framework-automationexercise.com/src/main/java/com/ae/tests/ <br> 

<img width="500" alt="" src="https://github.com/user-attachments/assets/dab80a16-db17-4400-a6d7-6d473e6511f6">  
<br><br>

Following are the test cases covered in the this Project:
- User registration  
- Login and logout  
- Searching for products  
- Adding products to cart  
- Placing orders with payment  
- Verifying cart behavior with login state  
- Subscription functionality  

**TestNG Annotations:** TestNG annotations like @Test, @BeforeMethod, and @AfterMethod are used to organize test methods, setup, and teardown logic. <br>

**Page Object Usage:** Test methods are used to initialize and use the page objects to interact with web elements on the pages under test.

---

## 📄 Logging with Log4j2
This project uses Log4j2 for structured and configurable logging of test execution to both the console and a log file.

🔧 Configuration File:  
Path: /Hybrid-selenium-automation-framework-automationexercise.com/src/test/resources/log4j2.properties  <br>

📁 Location:   
Logs are stored in /Hybrid-selenium-automation-framework-automationexercise.com/logs/  <br><br>
<img width="500" alt="" src="https://github.com/user-attachments/assets/68fcfa5b-bea2-4bcf-bbc2-a7976a326bf6">

---

## 📜 Reporting:

**Test Reporting:** Implemented test reporting using third-party reporting frameworks - ExtentReports. <br>
Reports are saved in the following location : "/guru99bankdemo/Reports/"<br>
<img width="500" alt="" src="https://github.com/user-attachments/assets/29e5760e-e37e-4b96-a037-8699caf574c5"> <br>

Extent Report opened automatically on the default browser after the execution is completed.<br>
<img width="1260" alt="" src="https://github.com/user-attachments/assets/5c4c3520-e3b5-46e8-8a2b-6d749e93fae0">
<img width="1260" alt="" src="https://github.com/user-attachments/assets/f23e50b4-629f-4a60-bb54-3fd441e16e5b">

---

## ⚙️ Jenkins Integration
I’ve integrated this framework with Jenkins to support automated test execution, both locally and through CI/CD pipelines.

✅ Running Locally in Jenkins (No GitHub Required)
I’ve configured the project to run directly from my local machine using a Jenkins Maven Project. Jenkins picks up the project from my local workspace, runs tests using Maven.  <br>
<img width="1260" alt="" src="https://github.com/user-attachments/assets/ec0bd03f-bbea-4e7b-9201-7223bbf9b6b9">  
<br>
<img width="1260" alt="" src="https://github.com/user-attachments/assets/5c26b422-66f5-4b08-8801-1c0197797a83">  
<br><br>
<img width="1260" alt="" src="https://github.com/user-attachments/assets/1d82aaa2-c3b6-4cf6-8a30-9e20a9131bb8">

---

## 🏃 Running the project:

✅ Pre-Requisites
- **Java JDK 11+**
- **Maven 3.6+**
- **Chrome / Firefox / Edge**
- **Eclipse IDE**
- **Internet connection**


### 🧪 Cloning the repository:
1. Clone [Hybrid-selenium-automation-framework-automationexercise.com](https://github.com/amulsinfal/Hybrid-selenium-automation-framework-automationexercise.com.git) project from Github<br> 
  ```
    git clone https://github.com/amulsinfal/Hybrid-selenium-automation-framework-automationexercise.com.git
  ```
2. Navigate to the cloned directory<br> 
  ```
    cd Hybrid-selenium-automation-framework-automationexercise.com
  ```   
3. Compile maven dependencies<br> 
  ```
    $ mvn compile
  ```
4. Run the following command
     ```
    $ mvn test
  ```
