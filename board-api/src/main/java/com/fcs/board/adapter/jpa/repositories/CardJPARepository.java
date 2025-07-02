package com.fcs.board.adapter.jpa.repositories;

import com.fcs.board.adapter.jpa.entities.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardJPARepository extends JpaRepository<CardEntity, Long> {
}

