package com.fcs.board.domain;

public class Column {
    private Long id;
    private Long boardId;
    private String name;
    private ColumnType type;
    private int position;
    private int cardLimit;

    public Column(Long boardId, String name, ColumnType type, int position, int cardLimit) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Column name cannot be null or empty");
        if (type == null) throw new IllegalArgumentException("Column type cannot be null");
        if (cardLimit < 0) throw new IllegalArgumentException("Card limit cannot be negative");
        this.boardId = boardId;
        this.name = name;
        this.type = type;
        this.position = position;
        this.cardLimit = cardLimit;
    }

    public Long getId() { return id; }
    public Long getBoardId() { return boardId; }
    public String getName() { return name; }
    public ColumnType getType() { return type; }
    public int getPosition() { return position; }
    public int getCardLimit() { return cardLimit; }

    public void setCardLimit(int cardLimit) {
        if (cardLimit < 0) throw new IllegalArgumentException("Card limit cannot be negative");
        this.cardLimit = cardLimit;
    }
}
