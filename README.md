# FinanceFlow

FinanceFlow is a full-stack personal finance management application designed to help users track income, manage expenses, set monthly budgets, and monitor their financial activity through a centralized dashboard.

This repository contains the **Spring Boot backend** for FinanceFlow.

## Features

* User registration and login
* JWT-based authentication
* Secure password hashing with BCrypt
* Expense management
* Income management
* Monthly budget management
* Dashboard financial summaries
* Expense category breakdown
* Monthly income and expense analysis
* Input validation and centralized exception handling
* PostgreSQL database integration
* RESTful APIs

## Tech Stack

### Backend

* Java 21
* Spring Boot
* Spring Data JPA
* Spring Security
* JWT
* Maven

### Database

* PostgreSQL

### API Testing

* Postman

## Architecture

FinanceFlow follows a layered backend architecture:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
PostgreSQL Database
```

Additional components include:

```text
Security
 ├── JWT Authentication
 ├── Password Encryption
 └── Request Authorization

Exception Handling
 ├── Validation Errors
 └── Resource Not Found Errors
```

## Main API Areas

| Area           | Purpose                                  |
| -------------- | ---------------------------------------- |
| Authentication | Registration and login                   |
| Users          | User-related operations                  |
| Expenses       | Create, view, update and delete expenses |
| Income         | Manage income records                    |
| Budgets        | Manage monthly category budgets          |
| Dashboard      | Financial summaries and analysis         |

## Configuration

Sensitive configuration values are provided through environment variables rather than being stored directly in the repository.

Required environment variables:

```text
DB_URL
DB_PASSWORD
JWT_SECRET
```

Example:

```text
DB_URL=jdbc:postgresql://localhost:5432/financeflow
DB_PASSWORD=your_database_password
JWT_SECRET=your_jwt_secret
```

The actual values should never be committed to GitHub.

## Running the Backend Locally

### 1. Clone the repository

```bash
git clone https://github.com/29Shraddha/FinanceFlow.git
cd FinanceFlow
```

### 2. Configure environment variables

Set the required environment variables:

```text
DB_URL
DB_PASSWORD
JWT_SECRET
```

The database username is currently configured as:

```text
postgres
```

### 3. Start the application

Using Maven:

```bash
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

The backend runs locally on:

```text
http://localhost:8080
```

## Database

FinanceFlow uses PostgreSQL.

Create a database named:

```text
financeflow
```

Spring Data JPA/Hibernate manages the application's database schema.

## Frontend

The FinanceFlow frontend is maintained in a separate repository.

**Frontend:** https://github.com/29Shraddha/FinanceFlow-frontend

The React frontend communicates with this backend through REST APIs.

## Project Status

FinanceFlow currently includes the core functionality required for personal finance management, including authentication, expense tracking, income tracking, budgeting, and dashboard analytics.

Further improvements planned include production deployment, additional security hardening, and deployment configuration.

## Author

**Shraddha Gadsing**

