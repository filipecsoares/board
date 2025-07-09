package com.fcs.board.application.ports;

import com.fcs.board.domain.Board;
import java.util.List;
import java.util.Optional;

public interface BoardRepository {
    Board save(Board board);
    Optional<Board> findById(Long id);
    List<Board> findAll();
    void deleteById(Long id);
}
