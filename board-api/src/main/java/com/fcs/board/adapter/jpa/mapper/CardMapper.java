package com.fcs.board.adapter.jpa.mapper;

import com.fcs.board.adapter.jpa.entities.CardEntity;
import com.fcs.board.domain.Card;

public class CardMapper {
    public static Card toDomain(CardEntity entity) {
        Card card = new Card(
            entity.getColumn() != null ? entity.getColumn().getId() : null,
            entity.getTitle(),
            entity.getDescription()
        );
        // Set additional fields
        return card;
    }

    public static CardEntity toEntity(Card domain) {
        // ColumnEntity should be set by service layer
        return new CardEntity(null, domain.getTitle(), domain.getDescription(), domain.getCreatedAt(), domain.isBlocked());
    }
}
