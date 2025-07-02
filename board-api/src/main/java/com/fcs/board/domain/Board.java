package com.fcs.board.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Board {
    private Long id;
    private String name;
    private LocalDateTime createdAt;
    private List<Column> columns;

    public Board(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Board name cannot be null or empty");
        }
        this.name = name;
        this.createdAt = LocalDateTime.now();
    }

    public Board(Long id, String name, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
