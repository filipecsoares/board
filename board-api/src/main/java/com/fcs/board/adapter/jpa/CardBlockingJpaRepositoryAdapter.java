package com.fcs.board.adapter.jpa;

import com.fcs.board.adapter.jpa.entities.CardBlockingEntity;
import com.fcs.board.adapter.jpa.mapper.CardBlockingMapper;
import com.fcs.board.application.ports.CardBlockingRepository;
import com.fcs.board.domain.CardBlocking;
import com.fcs.board.adapter.jpa.repositories.CardBlockingJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CardBlockingJpaRepositoryAdapter implements CardBlockingRepository {
    private final CardBlockingJpaRepository jpaRepository;

    public CardBlockingJpaRepositoryAdapter(CardBlockingJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public CardBlocking save(CardBlocking blocking) {
        CardBlockingEntity entity = CardBlockingMapper.toEntity(blocking);
        CardBlockingEntity saved = jpaRepository.save(entity);
        return CardBlockingMapper.toDomain(saved);
    }

    @Override
    public List<CardBlocking> findByCardId(Long cardId) {
        return jpaRepository.findByCardId(cardId)
                .stream()
                .map(CardBlockingMapper::toDomain)
                .collect(Collectors.toList());
    }
}
