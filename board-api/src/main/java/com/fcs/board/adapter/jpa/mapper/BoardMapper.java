package com.fcs.board.adapter.jpa.mapper;

import com.fcs.board.adapter.jpa.entities.BoardEntity;
import com.fcs.board.domain.Board;
import java.util.stream.Collectors;

public class BoardMapper {
    public static Board toDomain(BoardEntity entity) {
        Board board = new Board(entity.getId(), entity.getName(), entity.getCreatedAt());
        if (entity.getColumns() != null) {
            board.getColumns().addAll(
                entity.getColumns().stream().map(ColumnMapper::toDomain).collect(Collectors.toList())
            );
        }
        return board;
    }

    public static BoardEntity toEntity(Board domain) {
        BoardEntity entity = new BoardEntity(domain.getId(), domain.getName(), domain.getCreatedAt());
        // Columns mapping omitted for brevity
        return entity;
    }
}
