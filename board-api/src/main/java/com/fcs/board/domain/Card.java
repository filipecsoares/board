package com.fcs.board.domain;

import java.time.LocalDateTime;

public class Card {
    private Long id;
    private Long columnId;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private boolean blocked;
    private String blockReason;
    private LocalDateTime blockedAt;

    public Card(Long columnId, String title, String description) {
        if (title == null || title.isBlank()) throw new IllegalArgumentException("Card title cannot be null or empty");
        this.columnId = columnId;
        this.title = title;
        this.description = description;
        this.createdAt = LocalDateTime.now();
        this.blocked = false;
    }

    public void block(String reason) {
        if (this.blocked) throw new IllegalStateException("Card already blocked.");
        if (reason == null || reason.isBlank()) throw new IllegalArgumentException("Block reason required.");
        this.blocked = true;
        this.blockReason = reason;
        this.blockedAt = LocalDateTime.now();
    }

    public void unblock() {
        if (!this.blocked) throw new IllegalStateException("Card is not blocked.");
        this.blocked = false;
        this.blockReason = null;
        this.blockedAt = null;
    }

    public void moveTo(Long newColumnId) {
        if (newColumnId == null) throw new IllegalArgumentException("Target column required.");
        this.columnId = newColumnId;
    }

    // getters and setters
    public Long getId() { return id; }
    public Long getColumnId() { return columnId; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public boolean isBlocked() { return blocked; }
    public String getBlockReason() { return blockReason; }
    public LocalDateTime getBlockedAt() { return blockedAt; }
}
