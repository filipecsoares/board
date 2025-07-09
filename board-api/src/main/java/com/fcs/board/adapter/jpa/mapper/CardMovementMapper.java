package com.fcs.board.adapter.jpa.mapper;

import com.fcs.board.adapter.jpa.entities.CardMovementEntity;
import com.fcs.board.domain.CardMovement;

public class CardMovementMapper {
    public static CardMovement toDomain(CardMovementEntity entity) {
        return new CardMovement(
            entity.getCard() != null ? entity.getCard().getId() : null,
            entity.getFromColumn() != null ? entity.getFromColumn().getId() : null,
            entity.getToColumn() != null ? entity.getToColumn().getId() : null
        );
    }

    public static CardMovementEntity toEntity(CardMovement domain) {
        // CardEntity, ColumnEntity should be set by service layer
        return new CardMovementEntity(null, null, null, domain.getMovedAt());
    }
}
