package com.fcs.board.application.usecases;

import com.fcs.board.application.ports.CardRepository;
import com.fcs.board.application.ports.CardBlockingRepository;
import com.fcs.board.domain.Card;
import com.fcs.board.domain.CardBlocking;
import org.springframework.stereotype.Service;

@Service
public class UnblockCardUseCase {
    private final CardRepository cardRepository;
    private final CardBlockingRepository blockingRepository;

    public UnblockCardUseCase(CardRepository cardRepository, CardBlockingRepository blockingRepository) {
        this.cardRepository = cardRepository;
        this.blockingRepository = blockingRepository;
    }

    public Card unblock(Long cardId, String reason) {
        Card card = cardRepository.findById(cardId).orElseThrow();
        card.unblock();
        cardRepository.save(card);
        CardBlocking blocking = new CardBlocking(cardId, reason);
        blocking.unblock(reason);
        blockingRepository.save(blocking);
        return card;
    }
}
