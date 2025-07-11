package com.fcs.board.application.usecases;

import com.fcs.board.application.ports.CardRepository;
import com.fcs.board.application.ports.CardBlockingRepository;
import com.fcs.board.domain.Card;
import com.fcs.board.domain.CardBlocking;
import org.springframework.stereotype.Service;

@Service
public class BlockCardUseCase {
    private final CardRepository cardRepository;
    private final CardBlockingRepository blockingRepository;

    public BlockCardUseCase(CardRepository cardRepository, CardBlockingRepository blockingRepository) {
        this.cardRepository = cardRepository;
        this.blockingRepository = blockingRepository;
    }

    public Card block(Long cardId, String reason) {
        Card card = cardRepository.findById(cardId).orElseThrow();
        card.block(reason);
        cardRepository.save(card);
        CardBlocking blocking = new CardBlocking(cardId, reason);
        blockingRepository.save(blocking);
        return card;
    }
}
