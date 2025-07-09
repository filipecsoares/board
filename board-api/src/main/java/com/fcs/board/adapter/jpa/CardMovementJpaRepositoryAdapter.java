package com.fcs.board.adapter.jpa;

import com.fcs.board.adapter.jpa.entities.CardMovementEntity;
import com.fcs.board.adapter.jpa.mapper.CardMovementMapper;
import com.fcs.board.application.ports.CardMovementRepository;
import com.fcs.board.domain.CardMovement;
import com.fcs.board.adapter.jpa.repositories.CardMovementJpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CardMovementJpaRepositoryAdapter implements CardMovementRepository {
    private final CardMovementJpaRepository jpaRepository;

    public CardMovementJpaRepositoryAdapter(CardMovementJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public CardMovement save(CardMovement movement) {
        CardMovementEntity entity = CardMovementMapper.toEntity(movement);
        CardMovementEntity saved = jpaRepository.save(entity);
        return CardMovementMapper.toDomain(saved);
    }

    @Override
    public List<CardMovement> findByCardId(Long cardId) {
        return jpaRepository.findByCardId(cardId)
                .stream()
                .map(CardMovementMapper::toDomain)
                .collect(Collectors.toList());
    }
}
