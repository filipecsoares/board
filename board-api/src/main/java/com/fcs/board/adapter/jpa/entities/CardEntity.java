package com.fcs.board.adapter.jpa.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cards")
public class CardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "column_id", nullable = false)
    private ColumnEntity column;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(length = 2000)
    private String description;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private boolean blocked = false;

    public CardEntity() {}

    public CardEntity(ColumnEntity column, String title, String description, LocalDateTime createdAt, boolean blocked) {
        this.column = column;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.blocked = blocked;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public ColumnEntity getColumn() { return column; }
    public void setColumn(ColumnEntity column) { this.column = column; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public boolean isBlocked() { return blocked; }
    public void setBlocked(boolean blocked) { this.blocked = blocked; }
}
