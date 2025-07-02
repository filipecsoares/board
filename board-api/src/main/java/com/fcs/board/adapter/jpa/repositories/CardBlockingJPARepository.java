package com.fcs.board.adapter.jpa.repositories;

import com.fcs.board.adapter.jpa.entities.CardBlockingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardBlockingJPARepository extends JpaRepository<CardBlockingEntity, Long> {
}

