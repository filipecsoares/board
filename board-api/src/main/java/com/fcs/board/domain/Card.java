package com.fcs.board.domain;

import java.time.LocalDateTime;

public class Card {
    private Long id;
    private Long columnId;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private boolean blocked;
    // getters and setters
}
