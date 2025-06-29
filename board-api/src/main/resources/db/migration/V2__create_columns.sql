CREATE TABLE columns (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    board_id BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(32) NOT NULL,
    position INT NOT NULL,
    CONSTRAINT fk_columns_board FOREIGN KEY (board_id) REFERENCES boards(id)
);
