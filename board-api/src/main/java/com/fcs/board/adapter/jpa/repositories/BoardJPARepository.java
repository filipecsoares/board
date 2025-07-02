package com.fcs.board.adapter.jpa.repositories;

import com.fcs.board.adapter.jpa.entities.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardJPARepository extends JpaRepository<BoardEntity, Long> {
}

