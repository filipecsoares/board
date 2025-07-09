package com.fcs.board.application.ports;

import com.fcs.board.domain.CardMovement;
import java.util.List;

public interface CardMovementRepository {
    CardMovement save(CardMovement movement);
    List<CardMovement> findByCardId(Long cardId);
}
