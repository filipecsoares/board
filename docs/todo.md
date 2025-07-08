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
- [ ] `CardMovement` (track history)
- [ ] `CardBlocking` (block reasons and time)

## 🧩 JPA Entities

- [ ] Create `BoardEntity`, `ColumnEntity`, `CardEntity`, `CardMovementEntity`, `CardBlockingEntity`
- [ ] Implement mapping classes between entities and domain models

## 📚 Repositories

- [ ] Define repository interfaces (ports)
- [ ] Implement `JpaRepositoryAdapter` for each domain entity

## ⚙️ Use Cases

- [ ] `CreateBoardUseCase`
- [ ] `CreateCardUseCase`
- [ ] `MoveCardUseCase`
- [ ] `BlockCardUseCase`
- [ ] `UnblockCardUseCase`
- [ ] `GenerateReportUseCase`

## 🌐 REST Controllers

- [ ] `BoardController`
- [ ] `CardController`
- [ ] `ReportController`

## ✅ Validation & Error Handling

- [ ] Define DTOs with `@NotBlank`, `@Valid`, etc.
- [ ] Create global exception handler using `@ControllerAdvice`

## 📊 Reports

- [ ] Completion time report logic
- [ ] Blocking history report logic

## 🧪 Tests

- [ ] Unit tests for domain rules
- [ ] Unit tests for use cases
- [ ] Integration tests (controller + repository)

## 🎨 Frontend (Vue + Pure CSS)

- [ ] Create base layout and navigation
- [ ] Implement `HomePage.vue` (create/select/delete boards)
- [ ] Implement `BoardPage.vue` (display board, columns, cards)
- [ ] Implement `CardDetails.vue` (block/unblock/cancel/report)
- [ ] Style all views using custom CSS (`styles/main.css`)
- [ ] Connect Vue components to backend API using Axios

## 🚀 Deployment

- [ ] Prepare Dockerfile for backend and frontend
- [ ] Setup PostgreSQL instance for production
- [ ] Configure profiles: dev and prod