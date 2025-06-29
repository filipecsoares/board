package com.fcs.board.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Board {
    private Long id;
    private String name;
    private LocalDateTime createdAt;
    private List<Column> columns;
    // getters and setters
}
