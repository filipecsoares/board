package com.fcs.board.domain;

import java.time.LocalDateTime;

public class CardMovement {
    private Long id;
    private Long cardId;
    private Long fromColumnId;
    private Long toColumnId;
    private LocalDateTime movedAt;

    public CardMovement(Long cardId, Long fromColumnId, Long toColumnId) {
        if (cardId == null) throw new IllegalArgumentException("Card ID required");
        if (fromColumnId == null) throw new IllegalArgumentException("From column required");
        if (toColumnId == null) throw new IllegalArgumentException("To column required");
        this.cardId = cardId;
        this.fromColumnId = fromColumnId;
        this.toColumnId = toColumnId;
        this.movedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public Long getCardId() { return cardId; }
    public Long getFromColumnId() { return fromColumnId; }
    public Long getToColumnId() { return toColumnId; }
    public LocalDateTime getMovedAt() { return movedAt; }
}
