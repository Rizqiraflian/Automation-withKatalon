# Katalon Studio Automation Project

## Overview
This project automates test cases for [OrangeHRM](https://opensource-demo.orangehrmlive.com/). because of **Custom Keywords** is only available for Pro plan, this project leverages **called test cases** to modularize and reuse common functionalities across multiple test cases. Each module is represented by a separate test case, which can be called from other test cases when needed.

---

## Project Structure

### 1. Test Cases
- **Modular Test Cases**:  
  - Common functionalities (e.g., login, navigation, file upload) are implemented as separate test cases.
  - These are reused across the project by calling them in other test cases.
- **End-to-End Test Cases**:  
  - Combine modular test cases to form complete test scenarios.

### 2. Object Repository
- Stores all the test objects (locators for UI elements) organized by pages or modules.  

### 3. Profiles
- Contains environment-specific configurations such as:
- Base URL
- Encrypted credentials

---

## How This Project Works

### Key Practices:

1. **No Custom Keywords**:  
 - Instead of defining custom Groovy-based keywords, reusable logic is encapsulated in **called test cases**.
 - This approach simplifies the project structure and avoids the need for scripting knowledge.

2. **Modularization**:  
 - Modular test cases focus on specific functionality (e.g., login, add employee).
 - These are called using the `Call Test Case` feature in Katalon.

3. **Error Handling**:  
 - Assertions and verifications are included in modular test cases to ensure validation at each step.

---

## Benefits of Using Called Test Cases

1. **Readability**:  
 - Test cases remain simple and easy to understand without diving into complex scripting.

2. **Reusability**:  
 - Common functionalities are reusable across multiple scenarios, reducing duplication.

3. **Ease of Maintenance**:  
 - Changes to a module (e.g., login flow) only require updating the corresponding test case.


---

## Example Usage

### Login Test Case (`TC_Login`)
Handles the login process:
1. Sets the username and password fields.
2. Clicks the login button.
3. Verifies the user is redirected to the dashboard.

### Add Employee Test Case (`TC_AddEmployee`)
Adds a new employee:
1. Calls the `TC_Login` test case to log in.
2. Navigates to the "Add Employee" page.
3. Fills in employee details.
4. Verifies the employee was added successfully.

---

## How to Run

1. Open the project in Katalon Studio.
2. Configure the environment in the desired **Profile**.
3. Execute test cases individually or in a **Test Suite**.
4. View the execution reports for test results.

---

## Project Dependencies
- **Katalon Studio Free Version**
- Encrypted credentials for secure data handling.
- Git for version control.
