package com.fcs.board.adapter.jpa.mapper;

import com.fcs.board.adapter.jpa.entities.CardBlockingEntity;
import com.fcs.board.domain.CardBlocking;

public class CardBlockingMapper {
    public static CardBlocking toDomain(CardBlockingEntity entity) {
        CardBlocking cb = new CardBlocking(
            entity.getCard() != null ? entity.getCard().getId() : null,
            entity.getBlockReason()
        );
        // Set additional fields
        return cb;
    }

    public static CardBlockingEntity toEntity(CardBlocking domain) {
        // CardEntity should be set by service layer
        return new CardBlockingEntity(null, domain.getBlockedAt(), domain.getUnblockedAt(), domain.getBlockReason(), domain.getUnblockReason());
    }
}
