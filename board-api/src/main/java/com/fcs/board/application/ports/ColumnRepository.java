package com.fcs.board.application.ports;

import com.fcs.board.domain.Column;
import java.util.List;
import java.util.Optional;

public interface ColumnRepository {
    Column save(Column column);
    Optional<Column> findById(Long id);
    List<Column> findByBoardId(Long boardId);
    void deleteById(Long id);
}
