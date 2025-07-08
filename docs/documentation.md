# 📘 Card Board Manager – Project Documentation

## 1. Project Overview

This system is composed of two applications:

* **Backend:** `board-api` – developed with Spring Boot using Clean Architecture and Domain-Driven Design (DDD).
* **Frontend:** `board-ui` – a minimalist Vue.js application with Vite using pure CSS with black, blue, and white color scheme.

The platform allows task board management, supporting card movement with rules, blocking/unblocking, time tracking, and reporting.

---

## 2. Architecture Overview

The backend follows **Clean Architecture** and **Domain-Driven Design (DDD)**, organized around use cases and domain models.

### 2.1 Data and Logic Flow

```
Controller → Use Case → Repository (Port) → RepositoryJpa (Adapter) → Entity (JPA)
                                        ↘
                                        Domain Model (Business Rules)
```

---

## 3. Layer Responsibilities

| Layer                 | Description                                                      |
| --------------------- | ---------------------------------------------------------------- |
| **Controller**        | Receives HTTP requests, calls use cases, returns responses.      |
| **Use Case**          | Application-specific logic and orchestration of domain behavior. |
| **Domain Models**     | Rich business models with rules and invariants (DDD).            |
| **Repository (Port)** | Interface defining persistence operations.                       |
| **Repository JPA**    | Implements port using Spring Data JPA.                           |
| **JPA Entities**      | Persistence models only, without business logic.                 |

---

## 4. Backend – `board-api`

### 4.1 Technologies

* Java 21
* Spring Boot 3
* Spring Data JPA
* Spring Validation
* Flyway
* PostgreSQL (production)
* H2 (development)
* Springdoc OpenAPI (Swagger)
* Maven

---

## 5. Domain & Persistence Design

### 5.1 Domain Models

Located in `domain.model`, contain all business rules.

Example: `Card.java`

```java
public class Card {
    private boolean blocked;

    public void block(String reason) {
        if (this.blocked) throw new BusinessException("Card already blocked.");
        this.blocked = true;
        // register reason internally
    }
}
```

### 5.2 JPA Entities

Located in `adapters.persistence`, responsible only for persistence.

Example: `CardEntity.java`

```java
@Entity
public class CardEntity {
    @Id
    private UUID id;
    private String title;
    private boolean blocked;
}
```

### 5.3 Mapping Layer

Bi-directional mappers convert between domain and entity models.

---

## 6. Application Layer

Located in `application.usecases`, containing services that implement business flows.

Example: `CreateBoardUseCase.java`

```java
public class CreateBoardUseCase {
    public Board execute(String name) {
        Board board = new Board(name);
        return boardRepository.save(board);
    }
}
```

Use case depends only on ports and domain, not on framework or JPA.

---

## 7. REST Controllers

Located in `adapters.web`, handle endpoints and map DTOs.

```java
@PostMapping("/boards")
public ResponseEntity<BoardResponse> createBoard(@Valid @RequestBody BoardRequest request) {
    return ResponseEntity.ok(mapper.toResponse(useCase.execute(request.name())));
}
```

---

## 8. Reports

* **Completion Time:** Calculates time from card creation to final column.
* **Blocking Report:** Lists durations and reasons for card blocks.

---

## 9. Swagger / OpenAPI

* Swagger UI provided via springdoc-openapi.
* Access via: `http://localhost:8080/swagger-ui.html`.

---

## 10. Frontend – `board-ui`

### 10.1 Technologies

* Vue.js 3
* Vue Router
* Axios
* **Pure CSS** (no Tailwind, no frameworks)

### 10.2 Structure

```
board-ui/
├── public/
├── src/
│   ├── assets/
│   ├── components/
│   ├── views/
│   └── router/
├── styles/
│   └── main.css
├── main.js
└── vue.config.js
```

### 10.3 Views

* `HomePage.vue`: main menu
* `BoardPage.vue`: columns and cards
* `CardDetails.vue`: modal for card details

### 10.4 Proxy Configuration (for dev)

```js
module.exports = {
  devServer: {
    proxy: 'http://localhost:8080',
  },
};
```

---

## 11. How to Run

### Backend

```bash
cd board-api
mvn clean install
mvn spring-boot:run
```

### Frontend

```bash
cd board-ui
npm install
npm run serve
```

---

## 12. UML Diagram

See attached image for flow:
`BoardController → CreateBoardUseCase → BoardRepository → BoardRepositoryJpa → BoardEntity`
