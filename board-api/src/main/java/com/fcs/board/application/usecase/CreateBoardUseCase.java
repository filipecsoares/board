package com.fcs.board.application.usecase;

import com.fcs.board.application.repository.BoardRepository;
import com.fcs.board.domain.Board;

public class CreateBoardUseCase {

    private final BoardRepository boardRepository;

    public CreateBoardUseCase(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void execute(final String boardName) {
        final var board = new Board(boardName);
        boardRepository.create(board);
    }
}
