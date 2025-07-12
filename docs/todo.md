# TODO – Card Board Manager

## 🧱 Setup

- [x] Initialize `board-api` (Spring Boot, Maven, Java 21)
- [x] Add dependencies: Spring Web, Data JPA, Flyway, PostgreSQL, H2, Spring Validation, OpenAPI
- [x] Initialize `board-ui` (Vue 3 + vite + pure CSS)

## 📁 Backend Structure

- [x] Create packages: adapters, application (ports, usecases, dto), domain.model, config
- [x] Configure `application-dev.yml` and `application-prod.yml`
- [x] Configure CORS and Swagger

## 📦 Domain Models (DDD)

- [x] `Board` (structure, creation logic)
- [x] `Column` (type validation, limits)
- [x] `Card` (block, unblock, move logic)
- [x] `CardMovement` (track history)
- [x] `CardBlocking` (block reasons and time)

## 🧩 JPA Entities

- [x] Create `BoardEntity`, `ColumnEntity`, `CardEntity`, `CardMovementEntity`, `CardBlockingEntity`
- [x] Implement mapping classes between entities and domain models

## 📚 Repositories

- [x] Define repository interfaces (ports)
- [x] Implement `JpaRepositoryAdapter` for each domain entity

## ⚙️ Use Cases

- [x] `CreateBoardUseCase`
- [x] `CreateCardUseCase`
- [x] `MoveCardUseCase`
- [x] `BlockCardUseCase`
- [x] `UnblockCardUseCase`

## 🌐 REST Controllers

- [x] `BoardController`
- [x] `CardController`

## ✅ Validation & Error Handling

- [x] Define DTOs with `@NotBlank`, `@Valid`, etc.
- [x] Create global exception handler using `@ControllerAdvice`

## 📊 Reports

- [ ] Completion time report logic
- [ ] Blocking history report logic

## 🧪 Tests

- [ ] Unit tests for domain rules
- [ ] Unit tests for use cases
- [ ] Integration tests (controller + repository)

## 🎨 Frontend (Vue + Pure CSS)

- [x] Create base layout and navigation
- [x] Implement `HomePage.vue` (create/select/delete boards)
- [ ] Implement `BoardPage.vue` (display board, columns, cards)
- [ ] Implement `CardDetails.vue` (block/unblock/cancel/report)
- [ ] Style all views using custom CSS (`styles/main.css`)
- [ ] Connect Vue components to backend API using Axios

## 🚀 Deployment

- [ ] Prepare Dockerfile for backend and frontend
- [ ] Setup PostgreSQL instance for production
- [ ] Configure profiles: dev and prod