package com.fcs.board.adapter.jpa;

import com.fcs.board.adapter.jpa.entities.CardEntity;
import com.fcs.board.adapter.jpa.mapper.CardMapper;
import com.fcs.board.application.ports.CardRepository;
import com.fcs.board.domain.Card;
import com.fcs.board.adapter.jpa.repositories.CardJpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CardJpaRepositoryAdapter implements CardRepository {
    private final CardJpaRepository jpaRepository;

    public CardJpaRepositoryAdapter(CardJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Card save(Card card) {
        CardEntity entity = CardMapper.toEntity(card);
        CardEntity saved = jpaRepository.save(entity);
        return CardMapper.toDomain(saved);
    }

    @Override
    public Optional<Card> findById(Long id) {
        return jpaRepository.findById(id).map(CardMapper::toDomain);
    }

    @Override
    public List<Card> findByColumnId(Long columnId) {
        return jpaRepository.findByColumnId(columnId)
                .stream()
                .map(CardMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
