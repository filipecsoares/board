package com.fcs.board.adapter.jpa.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "card_movements")
public class CardMovementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "card_id", nullable = false)
    private CardEntity card;

    @ManyToOne
    @JoinColumn(name = "from_column_id")
    private ColumnEntity fromColumn;

    @ManyToOne(optional = false)
    @JoinColumn(name = "to_column_id", nullable = false)
    private ColumnEntity toColumn;

    @Column(nullable = false)
    private LocalDateTime movedAt;

    public CardMovementEntity() {}

    public CardMovementEntity(CardEntity card, ColumnEntity fromColumn, ColumnEntity toColumn, LocalDateTime movedAt) {
        this.card = card;
        this.fromColumn = fromColumn;
        this.toColumn = toColumn;
        this.movedAt = movedAt;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public CardEntity getCard() { return card; }
    public void setCard(CardEntity card) { this.card = card; }
    public ColumnEntity getFromColumn() { return fromColumn; }
    public void setFromColumn(ColumnEntity fromColumn) { this.fromColumn = fromColumn; }
    public ColumnEntity getToColumn() { return toColumn; }
    public void setToColumn(ColumnEntity toColumn) { this.toColumn = toColumn; }
    public LocalDateTime getMovedAt() { return movedAt; }
    public void setMovedAt(LocalDateTime movedAt) { this.movedAt = movedAt; }
}
