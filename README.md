# Card Board Manager

A study project for learning and demonstrating Clean Architecture, Spring Boot, and Vue.js through the implementation of a card board management system. This project is designed for educational purposes and showcases best practices in backend and frontend development, domain-driven design, and modern software engineering.

---

## Table of Contents
- [Project Overview](#project-overview)
- [Features](#features)
- [Architecture](#architecture)
- [Backend (Spring Boot)](#backend-spring-boot)
- [Frontend (Vue.js)](#frontend-vuejs)
- [Database & Migrations](#database--migrations)
- [Reports](#reports)
- [Development Setup](#development-setup)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

---

## Project Overview

Card Board Manager is a web application for organizing tasks on boards, inspired by Kanban. It allows users to create boards, manage columns and cards, track card movements, block/unblock cards with justifications, and generate reports on task completion and blocking history.

This project is intended for study and experimentation with:
- Clean Architecture principles
- Spring Boot (Java) for the backend
- Vue.js for the frontend
- H2 in-memory database and Flyway for migrations

## Features
- **Board Management:** Create, select, and delete boards
- **Column Structure:** Columns of types Initial, Pending, Final, and Canceled, with business rules for positioning and quantity
- **Card Management:** Create cards with title, description, creation date, and blocking status; move cards between columns; block/unblock cards with justification; cancel cards
- **Business Rules:** Sequential movement, exception for direct movement to Canceled, block movement of blocked cards
- **Reports:** Task completion time and card blocking history
- **REST API:** Exposes endpoints for all operations
- **Frontend:** Responsive UI with Vue.js and Tailwind CSS

## Architecture

The project follows **Clean Architecture** to ensure separation of concerns and maintainability:

```
+------------------+
|    Frameworks    |  (Web, DB, UI)
+--------+---------+
         ^
+--------+---------+
|    Adapters      |  (Controllers, Repositories, Presenters)
+--------+---------+
         ^
+--------+---------+
|   Use Cases      |  (Application Business Rules)
+--------+---------+
         ^
+--------+---------+
|     Domains      |  (Enterprise Business Rules)
+------------------+
```

- **Entities:** Core business models (Board, Column, Card, CardMovement, CardBlocking)
- **Use Cases:** Application-specific business logic and interfaces (ports)
- **Adapters:** Controllers (REST), repositories (JPA), presenters
- **Frameworks:** Spring Boot, H2, Flyway, Vue.js

## Backend (Spring Boot)
- **Language:** Java 21+
- **Framework:** Spring Boot
- **Persistence:** JPA/Hibernate, H2 (in-memory, dev), PostgreSQL (prod)
- **Migrations:** Flyway
- **Structure:**
  - `domain`: Entities and enums (e.g., `Board`, `ColumnType`)
  - `application`: Use cases, services, DTOs, ports
  - `adapter`: Controllers, repositories
  - `config`: Application configuration (CORS, database)
- **Key Classes:**
  - `Board`, `Column`, `Card`, `CardMovement`, `CardBlocking` (entities)
  - `BoardController`, `CardController` (REST endpoints)
- **Business Rules:**
  - Sequential card movement
  - Exception for direct move to Canceled
  - Blocked cards cannot be moved
  - Justification required for blocking/unblocking
- **Profiles:**
  - `dev`: H2 in-memory database
  - `prod`: PostgreSQL (see Docker setup)

## Frontend (Vue.js)
- **Language:** TypeScript (Vue 3 + Vite)
- **Structure:**
  - `HomePage.vue`: Main menu (create/select/delete boards)
  - `BoardPage.vue`: Board view with columns and cards
  - `CardDetails.vue`: Card details and actions
- **Styling:** Pure CSS (`src/styles/main.css`), minimalist and responsive
- **API Integration:** Communicates with backend via REST using Axios

## Database & Migrations
- **Database:**
  - H2 (in-memory, for development)
  - PostgreSQL (for production, via Docker)
- **Migrations:** Flyway scripts in `src/main/resources/db/migration`
- **Entities:**
  - `BoardEntity`, `ColumnEntity`, `CardEntity`, `CardMovementEntity`, `CardBlockingEntity`
- **Configuration:**
  - Database and Flyway settings in `application.yml` and environment variables

## Reports
- **Task Completion Time:** Calculates time spent by each card in columns and total time to completion
- **Card Blocking History:** Details block/unblock events, durations, and justifications

## Development Setup

## Development & Deployment

### Prerequisites
- Java 21+
- Maven 3.6+
- Node.js & npm (or Yarn)
- Docker & Docker Compose

### Local Development

#### Backend (Spring Boot)
```bash
# Clone the repository
git clone <REPO_URL>
cd board/board-api
mvn clean install
mvn spring-boot:run
# Backend runs at http://localhost:8080
```

#### Frontend (Vue.js)
```bash
cd ../board-ui
npm install
npm run dev
# Frontend runs at http://localhost:5173
```

### Docker Compose (Production-like Setup)

To run the backend, frontend, and PostgreSQL database together:

```bash
docker-compose up --build
# Backend: http://localhost:8080
# Frontend: http://localhost
# PostgreSQL: localhost:5432 (user: boarduser, pass: boardpass, db: board)
```

This will use the `prod` profile for the backend and connect to the PostgreSQL container.

## Testing
- **Backend:**
  - Unit tests for domain and use cases
  - Integration tests for controllers and repositories
- **Frontend:**
  - Component and integration tests (recommended)

## Contributing
This project is for study and experimentation. Contributions, suggestions, and questions are welcome! Please open an issue or submit a pull request.

## License
This project is licensed for educational and non-commercial use only.

---

*Created for study purposes. Designed and documented by Filipe.*
