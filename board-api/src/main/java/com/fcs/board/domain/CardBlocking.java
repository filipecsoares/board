package com.fcs.board.domain;

import java.time.LocalDateTime;

public class CardBlocking {
    private Long id;
    private Long cardId;
    private LocalDateTime blockedAt;
    private LocalDateTime unblockedAt;
    private String blockReason;
    private String unblockReason;

    public CardBlocking(Long cardId, String blockReason) {
        if (cardId == null) throw new IllegalArgumentException("Card ID required");
        if (blockReason == null || blockReason.isBlank()) throw new IllegalArgumentException("Block reason required");
        this.cardId = cardId;
        this.blockReason = blockReason;
        this.blockedAt = LocalDateTime.now();
    }

    public void unblock(String reason) {
        if (this.unblockedAt != null) throw new IllegalStateException("Already unblocked");
        this.unblockedAt = LocalDateTime.now();
        this.unblockReason = reason;
    }

    public Long getId() { return id; }
    public Long getCardId() { return cardId; }
    public LocalDateTime getBlockedAt() { return blockedAt; }
    public LocalDateTime getUnblockedAt() { return unblockedAt; }
    public String getBlockReason() { return blockReason; }
    public String getUnblockReason() { return unblockReason; }
}
