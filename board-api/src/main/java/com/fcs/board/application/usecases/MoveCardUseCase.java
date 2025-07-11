package com.fcs.board.application.usecases;

import com.fcs.board.application.ports.CardRepository;
import com.fcs.board.application.ports.CardMovementRepository;
import com.fcs.board.domain.Card;
import com.fcs.board.domain.CardMovement;
import org.springframework.stereotype.Service;

@Service
public class MoveCardUseCase {
    private final CardRepository cardRepository;
    private final CardMovementRepository movementRepository;

    public MoveCardUseCase(CardRepository cardRepository, CardMovementRepository movementRepository) {
        this.cardRepository = cardRepository;
        this.movementRepository = movementRepository;
    }

    public Card move(Long cardId, Long fromColumnId, Long toColumnId) {
        Card card = cardRepository.findById(cardId).orElseThrow();
        card.moveTo(toColumnId);
        cardRepository.save(card);
        CardMovement movement = new CardMovement(cardId, fromColumnId, toColumnId);
        movementRepository.save(movement);
        return card;
    }
}
