package com.fcs.board.adapter.jpa.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "card_blockings")
public class CardBlockingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "card_id", nullable = false)
    private CardEntity card;

    @Column(nullable = false)
    private LocalDateTime blockedAt;

    private LocalDateTime unblockedAt;

    @Column(length = 255)
    private String blockReason;

    @Column(length = 255)
    private String unblockReason;

    public CardBlockingEntity() {}

    public CardBlockingEntity(CardEntity card, LocalDateTime blockedAt, LocalDateTime unblockedAt, String blockReason, String unblockReason) {
        this.card = card;
        this.blockedAt = blockedAt;
        this.unblockedAt = unblockedAt;
        this.blockReason = blockReason;
        this.unblockReason = unblockReason;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public CardEntity getCard() { return card; }
    public void setCard(CardEntity card) { this.card = card; }
    public LocalDateTime getBlockedAt() { return blockedAt; }
    public void setBlockedAt(LocalDateTime blockedAt) { this.blockedAt = blockedAt; }
    public LocalDateTime getUnblockedAt() { return unblockedAt; }
    public void setUnblockedAt(LocalDateTime unblockedAt) { this.unblockedAt = unblockedAt; }
    public String getBlockReason() { return blockReason; }
    public void setBlockReason(String blockReason) { this.blockReason = blockReason; }
    public String getUnblockReason() { return unblockReason; }
    public void setUnblockReason(String unblockReason) { this.unblockReason = unblockReason; }
}
