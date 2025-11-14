# Web-Testing-Framework

## Goal of the Project
The goal of this project is to automate the testing of the [Demoblaze](https://demoblaze.com/index.html) web application to ensure its functionality, reliability, and performance. This project focuses on testing key user interactions such as browsing products, adding items to the cart, and completing transactions.

## Test Framework Setup
To set up the test framework, follow these steps:

1. **Clone the repository:**
   ```bash
   git clone https://github.com/wxjiha/Web-Testing-Framework.git
   cd Web-Testing-Framework
2. **Install dependencies:**
The project uses Maven for dependency management. Run:
   mvn clean install
   ```bash
   mvn clean install

3. Configure browser drivers:
Ensure the correct WebDriver (e.g., ChromeDriver) is available and added to your system PATH.

4. Run tests:
Execute all tests with:
   ```bash
   mvn test

What Was Tested:

- Navigation through product categories
- Product detail viewing
- Adding products to the shopping cart
- User registration and login
- Checkout process
- Alert handling and form validation
  
Tests are implemented in src/test and use Selenium WebDriver for browser automation.

Test Metrics
- Total Tests: 30
- Passed Tests: 27
- Failed Tests: 1
- Skipped Tests: 2


