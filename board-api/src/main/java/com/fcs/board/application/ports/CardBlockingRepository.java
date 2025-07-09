package com.fcs.board.application.ports;

import com.fcs.board.domain.CardBlocking;
import java.util.List;

public interface CardBlockingRepository {
    CardBlocking save(CardBlocking blocking);
    List<CardBlocking> findByCardId(Long cardId);
}
