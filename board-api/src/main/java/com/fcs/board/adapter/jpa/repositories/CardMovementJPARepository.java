package com.fcs.board.adapter.jpa.repositories;

import com.fcs.board.adapter.jpa.entities.CardMovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardMovementJPARepository extends JpaRepository<CardMovementEntity, Long> {
}

