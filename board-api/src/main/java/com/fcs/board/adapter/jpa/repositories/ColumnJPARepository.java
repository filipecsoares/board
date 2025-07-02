package com.fcs.board.adapter.jpa.repositories;

import com.fcs.board.adapter.jpa.entities.ColumnEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColumnJPARepository extends JpaRepository<ColumnEntity, Long> {
}

