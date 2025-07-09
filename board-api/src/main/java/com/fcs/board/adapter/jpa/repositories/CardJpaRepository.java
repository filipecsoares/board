package com.fcs.board.adapter.jpa.repositories;

import com.fcs.board.adapter.jpa.entities.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CardJpaRepository extends JpaRepository<CardEntity, Long> {
    List<CardEntity> findByColumnId(Long columnId);
}
