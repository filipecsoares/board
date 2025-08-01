package com.fcs.board.adapter.web;

import com.fcs.board.adapter.web.dto.CardRequest;
import com.fcs.board.adapter.web.dto.CardResponse;
import com.fcs.board.application.usecases.CreateCardUseCase;
import com.fcs.board.domain.Card;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cards")
public class CardController {
    private final CreateCardUseCase createCardUseCase;

    public CardController(CreateCardUseCase createCardUseCase) {
        this.createCardUseCase = createCardUseCase;
    }

    @PostMapping
    public ResponseEntity<CardResponse> createCard(@Valid @RequestBody CardRequest request) {
        Card card = createCardUseCase.execute(request.columnId(), request.title(), request.description());
        return ResponseEntity.ok(new CardResponse(card.getId(), card.getColumnId(), card.getTitle(), card.getDescription(), card.getCreatedAt(), card.isBlocked()));
    }
}
