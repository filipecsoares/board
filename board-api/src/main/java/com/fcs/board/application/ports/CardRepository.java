package com.fcs.board.application.ports;

import com.fcs.board.domain.Card;
import java.util.List;
import java.util.Optional;

public interface CardRepository {
    Card save(Card card);
    Optional<Card> findById(Long id);
    List<Card> findByColumnId(Long columnId);
    void deleteById(Long id);
}
