Project Documentation: Card Board Manager
1. Project Overview

This document details the design and implementation of a card board management system, developed with Spring Boot for the backend and Vue.js for the frontend. The main objective is to provide a robust platform for organizing tasks on boards, allowing card management through different columns, with blocking functionalities, time tracking, and reports.
Key Requirements:

    Board Management: Creation, selection, and deletion.

    Column Structure: Specific types (Initial, Canceled, Final, Pending) with positioning and quantity rules.

    Card Management: Title, description, creation date, blocked status, movement between columns.

    Business Rules for Movement: Sequential movement, exceptions for the canceled column, blocking/unblocking with justification.

    Reports: Task completion time and card blocking history.

2. Architecture

The project will follow a Clean Architecture approach, aiming to separate concerns into distinct layers and ensure independence from frameworks, UI, and databases.

+------------------+
|    Frameworks    |  (Web, DB, UI)
+--------+---------+
^
|
+--------+---------+
|    Adapters      |  (Controllers, Repositories, Presenters)
+--------+---------+
^
|
+--------+---------+
|   Use Cases      |  (Application Business Rules)
+--------+---------+
^
|
+--------+---------+
|   Entities       |  (Enterprise Business Rules)
+------------------+

Layers:

    Entities (Entities / Domain): Contains the most important business rules of the application. These are pure Java objects (POJOs) that represent the domain concepts (Board, Column, Card, CardMovement, CardBlocking). They have no dependency on any other layer.

        Board.java

        Column.java

        Card.java

        CardMovement.java

        CardBlocking.java

    Use Cases (Use Cases / Application): Contains the specific business rules of the application. Orchestrates the flow of data to and from the Entities. Defines interfaces (Ports) that Adapters must implement.

        Interfaces for Board, Column, Card operations.

        Service classes that implement business logic (e.g., BoardService, CardService).

        Input/Output Ports (DTOs for communication between layers).

    Adapters (Adapters / Infrastructure): Connects Use Cases with the external world (Frameworks, Database, UI). Implement the interfaces defined in the Use Cases.

        Controllers (Web): Map HTTP requests to Use Case calls. (Ex: BoardController, CardController).

        Repositories (Persistence): Implement data persistence using JPA/Hibernate. (Ex: BoardRepository, CardRepository).

        Presenters (Optional for backend): Format the output of Use Cases for the UI (more relevant for server-side rendering frontend, but here JSON is the primary format).

    Frameworks and Drivers (Frameworks & Drivers): Contains implementation details of frameworks and tools.

        Spring Boot (@SpringBootApplication, WebMvcConfigurer).

        H2 Database (configuration).

        Flyway (configuration and scripts).

        JPA/Hibernate (configuration).

3. Backend (Spring Boot)
   3.1. Dependencies (pom.xml)

The pom.xml file will include necessary dependencies for Spring Boot, Web, JPA, H2 database, Flyway, testing utilities, and others.
3.2. Project Structure

The project will be structured to reflect the Clean Architecture layers, with packages for config, domain, application (ports, services, dtos), adapter (web, persistence), and a main application class.
3.3. Database Schema (JPA Entities)

JPA entities will be mapped to tables in the H2 database. These include BoardEntity, ColumnEntity, CardEntity, CardMovementEntity, and CardBlockingEntity, with appropriate relationships and fields to store board, column, card, movement history, and blocking details.
3.4. Enum ColumnType.java

An enum will define the types of columns: INITIAL, PENDING, FINAL, CANCELED.
3.5. Ports and Use Cases (Application Layer)

Interfaces like BoardUseCase and CardUseCase will define the business operations. BoardRepositoryPort and CardRepositoryPort will be interfaces for persistence adapters. Service classes (e.g., BoardService, CardService) will implement the business logic and orchestrate operations using these ports. DTOs (Data Transfer Objects) will be used for communication between layers.
3.6. Controllers (Adapters - Web)

REST controllers will expose endpoints for the frontend. These will handle HTTP requests for creating, retrieving, updating, and deleting boards and cards, as well as specific actions like moving cards and generating reports.
3.7. CORS Configuration

CORS (Cross-Origin Resource Sharing) will be configured in WebConfig.java to allow the Vue.js frontend (running on a different port) to communicate with the Spring Boot backend.
4. Migrations (Flyway)

Flyway will manage the database schema. SQL scripts for creating tables (boards, columns, cards, card_movements, card_blockings) will be located in src/main/resources/db/migration.
Configuration Flyway (application.properties)

The application.properties will configure the H2 in-memory database, JPA settings, and enable Flyway, pointing to the migration scripts.
5. Frontend (Vue.js)

The frontend will be a simple Vue.js application to interact with the Spring Boot API.
5.1. Vue.js Project Structure (Example)

The frontend project will have a standard Vue CLI structure, including public, src (assets, components, views), router, and configuration files.
5.2. Main Components

    HomePage.vue: Displays the main menu: Create New Board, Select Board, Delete Boards.

    BoardList.vue: Lists existing boards for selection/deletion.

    BoardPage.vue: Displays the selected board with its columns and cards. Allows interaction with cards (move, create, block, unblock, cancel).

    Column.vue: Component to render a single column and its cards.

    CardDetails.vue: Displays card details and allows specific operations (block/unblock).

5.3. main.js (Vue CLI) Example

This file initializes the Vue application, integrates the router, and mounts the root component.
5.4. router/index.js Example

This file defines the routing for the Vue.js application, mapping URLs to Vue components (e.g., / to HomePage.vue, /board/:id to BoardPage.vue).
5.5. HomePage.vue (Main Menu) Example

This Vue component provides the main menu interface, allowing users to create, select, and delete boards through modal interactions and API calls. It includes basic styling with Tailwind CSS.
5.6. BoardPage.vue (Board View) Example

This Vue component displays a specific board, fetching its columns and cards. It provides buttons for card actions (move, cancel, block, unblock) and report generation. Modals are used for creating cards, blocking/unblocking, and confirming cancellation. It leverages Tailwind CSS for responsive layout.
5.7. vue.config.js (Optional, for API proxy)

An optional vue.config.js can be used to set up a development proxy, forwarding API requests from the frontend to the backend to avoid CORS issues during development.
6. Reports

Two types of reports are required: task completion time and blocking history. The logic for generating these reports will be implemented in the backend.
6.1. Completion Time Report

This report will analyze CardMovementEntity to calculate the time each card spent in each column and the total time until completion (arrival at the FINAL column). This involves iterating through card movements, calculating durations between movement and exit times (or subsequent movement times), and summarizing the information.
6.2. Card Blocking Report

This report will analyze CardBlockingEntity to detail card blockings. It will involve fetching blocking records, calculating the duration of each block (if unblocked), and formatting the reasons for blocking and unblocking.
7. Next Steps and Development Configuration
   7.1. Prerequisites

   Java Development Kit (JDK) 21+

   Maven 3.6+

   Node.js and npm (or Yarn)

7.2. How to Run the Backend (Spring Boot)

    Clone the project: (When available)
    git clone <YOUR_REPOSITORY_URL>
    cd card-board-manager

    Build the Maven project:
    mvn clean install

    Run the Spring Boot application:
    mvn spring-boot:run
    The backend will be available at http://localhost:8080.

7.3. How to Run the Frontend (Vue.js)

    Navigate to the frontend directory:
    cd ../card-board-frontend

    Install dependencies:
    npm install (or yarn install)

    Run the Vue development server:
    npm run serve (or yarn serve)
    The frontend will be available at http://localhost:8081 (or another defined port).

7.4. Development Considerations

    Input Validation: Implement robust validation on all input DTOs and endpoints.

    Error Handling: Implement global error handling in Spring Boot (@ControllerAdvice) to provide user-friendly error responses.

    Testing: Write unit tests for the domain layer and use cases, and integration tests for controllers and repositories.

    Authentication/Authorization: For a production environment, authentication (e.g., Spring Security) and authorization would need to be added.

    UI Improvements: The Vue.js frontend can be enhanced with more styling, animations, and visual feedback.

    Persistence: For production, consider a persistent database like PostgreSQL or MySQL instead of H2 in-memory.