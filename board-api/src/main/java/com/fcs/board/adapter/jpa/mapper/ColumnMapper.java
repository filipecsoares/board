package com.fcs.board.adapter.jpa.mapper;

import com.fcs.board.adapter.jpa.entities.ColumnEntity;
import com.fcs.board.domain.Column;

public class ColumnMapper {
    public static Column toDomain(ColumnEntity entity) {
        return new Column(
            entity.getBoard() != null ? entity.getBoard().getId() : null,
            entity.getName(),
            entity.getType(),
            entity.getPosition(),
            0 // cardLimit not present in entity
        );
    }

    public static ColumnEntity toEntity(Column domain) {
        // BoardEntity should be set by service layer
        return new ColumnEntity(null, domain.getName(), domain.getType(), domain.getPosition());
    }
}
