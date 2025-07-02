package com.fcs.board.application.repository;

import com.fcs.board.domain.Board;

public interface BoardRepository {
    Board create(Board board);
}
