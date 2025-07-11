package com.fcs.board.application.usecases;

import com.fcs.board.application.ports.CardRepository;
import com.fcs.board.domain.Card;
import org.springframework.stereotype.Service;

@Service
public class CreateCardUseCase {
    private final CardRepository cardRepository;

    public CreateCardUseCase(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Card execute(Long columnId, String title, String description) {
        Card card = new Card(columnId, title, description);
        return cardRepository.save(card);
    }
}
