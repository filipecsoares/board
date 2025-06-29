CREATE TABLE card_blockings (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    card_id BIGINT NOT NULL,
    blocked_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    unblocked_at TIMESTAMP,
    block_reason VARCHAR(255),
    unblock_reason VARCHAR(255),
    CONSTRAINT fk_blockings_card FOREIGN KEY (card_id) REFERENCES cards(id)
);
