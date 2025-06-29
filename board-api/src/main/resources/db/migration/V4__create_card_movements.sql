CREATE TABLE card_movements (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    card_id BIGINT NOT NULL,
    from_column_id BIGINT,
    to_column_id BIGINT NOT NULL,
    moved_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_movements_card FOREIGN KEY (card_id) REFERENCES cards(id),
    CONSTRAINT fk_movements_from_column FOREIGN KEY (from_column_id) REFERENCES columns(id),
    CONSTRAINT fk_movements_to_column FOREIGN KEY (to_column_id) REFERENCES columns(id)
);
