package com.fcs.board.adapter.jpa.repositories;

import com.fcs.board.adapter.jpa.entities.CardBlockingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CardBlockingJpaRepository extends JpaRepository<CardBlockingEntity, Long> {
    List<CardBlockingEntity> findByCardId(Long cardId);
}
