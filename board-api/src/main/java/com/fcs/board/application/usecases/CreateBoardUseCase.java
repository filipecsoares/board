package com.fcs.board.application.usecases;

import com.fcs.board.application.ports.BoardRepository;
import com.fcs.board.domain.Board;
import org.springframework.stereotype.Service;

@Service
public class CreateBoardUseCase {
    private final BoardRepository boardRepository;

    public CreateBoardUseCase(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Board execute(String name) {
        Board board = new Board(name);
        return boardRepository.save(board);
    }
}
