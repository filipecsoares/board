package com.fcs.board.adapter.jpa.entities;

import com.fcs.board.domain.ColumnType;
import jakarta.persistence.*;

@Entity
@Table(name = "columns")
public class ColumnEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    private BoardEntity board;

    private String name;

    @Enumerated(EnumType.STRING)
    private ColumnType type;

    private int position;

    public ColumnEntity() {
    }

    public ColumnEntity(BoardEntity board, String name, ColumnType type, int position) {
        this.board = board;
        this.name = name;
        this.type = type;
        this.position = position;
    }

    public ColumnEntity(Long id, BoardEntity board, String name, ColumnType type, int position) {
        this.id = id;
        this.board = board;
        this.name = name;
        this.type = type;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BoardEntity getBoard() {
        return board;
    }

    public void setBoard(BoardEntity board) {
        this.board = board;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ColumnType getType() {
        return type;
    }

    public void setType(ColumnType type) {
        this.type = type;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
