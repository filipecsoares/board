package com.fcs.board.domain;

import java.time.LocalDateTime;

public class CardBlocking {
    private Long id;
    private Long cardId;
    private LocalDateTime blockedAt;
    private LocalDateTime unblockedAt;
    private String blockReason;
    private String unblockReason;
    // getters and setters
}
