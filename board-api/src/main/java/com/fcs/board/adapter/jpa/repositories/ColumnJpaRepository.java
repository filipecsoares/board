package com.fcs.board.adapter.jpa.repositories;

import com.fcs.board.adapter.jpa.entities.ColumnEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ColumnJpaRepository extends JpaRepository<ColumnEntity, Long> {
    List<ColumnEntity> findByBoardId(Long boardId);
}
