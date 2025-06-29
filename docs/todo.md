# Requirements Checklist for the Card Board Manager

## 1. Fundamental Infrastructure Requirements
- [x] Configure the backend project with Spring Boot, including dependencies for Web, JPA, H2, Flyway, and testing
- [x] Configure the frontend project with Vue.js, including the standard structure for components, views, and routing
- [x] Configure the in-memory H2 database for development
- [x] Configure Flyway for versioning and execution of database migration scripts
- [x] Create Flyway migration scripts for the tables: boards, columns, cards, card_movements, card_blockings
- [ ] Configure CORS in the backend to allow communication with the frontend

## 2. Domain and Architecture Requirements
- [ ] Implement Clean Architecture with separation into layers: Entities, Use Cases, Adapters, Frameworks
- [ ] Create domain entities: Board, Column, Card, CardMovement, CardBlocking
- [ ] Implement the ColumnType enum with values: INITIAL, PENDING, FINAL, CANCELED
- [ ] Map JPA entities to the corresponding tables in the database
- [ ] Define interfaces (ports) for operations on Board, Column, and Card
- [ ] Implement business services (BoardService, CardService) following business rules
- [ ] Create DTOs for communication between layers

## 3. Functional Requirements - Backend
### 3.1. Board Management
- [ ] Allow creation of new boards
- [ ] Allow selection of existing boards
- [ ] Allow deletion of boards

### 3.2. Column Structure
- [ ] Allow creation of columns with specific types (Initial, Pending, Final, Canceled)
- [ ] Implement rules for positioning and quantity of columns by type

### 3.3. Card Management
- [ ] Allow creation of cards with title, description, creation date, and blocking status
- [ ] Allow movement of cards between columns, respecting business rules
- [ ] Allow blocking and unblocking of cards, requiring justification
- [ ] Allow cancellation of cards (movement to the Canceled column)

### 3.4. Business Rules for Movement
- [ ] Implement sequential movement of cards between columns
- [ ] Allow exception for direct movement to the Canceled column
- [ ] Block movement of blocked cards

### 3.5. Reports
- [ ] Generate a report on task completion time (analyzing CardMovement)
- [ ] Generate a report on the history of card blockings (analyzing CardBlocking)

### 3.6. REST API
- [ ] Expose REST endpoints for operations on creating, retrieving, updating, and deleting boards and cards
- [ ] Expose endpoints for card movement, blocking/unblocking, and report generation

## 4. Functional Requirements - Frontend
- [ ] Implement HomePage.vue with the main menu: create, select, and delete boards
- [ ] Implement BoardList.vue to list existing boards
- [ ] Implement BoardPage.vue to display the selected board, columns, and cards, with actions for movement, blocking, unblocking, and cancellation
- [ ] Implement Column.vue to render columns and cards
- [ ] Implement CardDetails.vue to display card details and operations
- [ ] Integrate the frontend with the backend via REST API
- [ ] Implement modals for creating, blocking/unblocking, and confirming card cancellation
- [ ] Use Tailwind CSS for responsive layout and styling
- [ ] Configure development proxy (vue.config.js) to avoid CORS issues

## 5. Non-Functional Requirements
- [ ] Validate all input data in DTOs and endpoints
- [ ] Implement global error handling in the backend using @ControllerAdvice
- [ ] Write unit tests for the domain layer and use cases
- [ ] Write integration tests for controllers and repositories
- [ ] Ensure the system is easily adaptable for use with a persistent database (e.g., PostgreSQL, MySQL)
- [ ] Ensure separation of responsibilities between layers (Clean Architecture)
- [ ] Document the code and APIs clearly
- [ ] Consider authentication and authorization for production environments (e.g., Spring Security)
- [ ] Provide visual feedback and enhanced usability in the user interface
