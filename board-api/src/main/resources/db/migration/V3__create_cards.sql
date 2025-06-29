CREATE TABLE cards (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    column_id BIGINT NOT NULL,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    blocked BOOLEAN DEFAULT FALSE,
    CONSTRAINT fk_cards_column FOREIGN KEY (column_id) REFERENCES columns(id)
);
