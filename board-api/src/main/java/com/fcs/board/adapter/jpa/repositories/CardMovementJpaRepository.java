package com.fcs.board.adapter.jpa.repositories;

import com.fcs.board.adapter.jpa.entities.CardMovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CardMovementJpaRepository extends JpaRepository<CardMovementEntity, Long> {
    List<CardMovementEntity> findByCardId(Long cardId);
}
