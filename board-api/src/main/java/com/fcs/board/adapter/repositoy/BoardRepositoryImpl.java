package com.fcs.board.adapter.repositoy;

import com.fcs.board.adapter.jpa.entities.BoardEntity;
import com.fcs.board.adapter.jpa.repositories.BoardJPARepository;
import com.fcs.board.application.repository.BoardRepository;
import com.fcs.board.domain.Board;
import org.springframework.stereotype.Repository;

@Repository
public class BoardRepositoryImpl implements BoardRepository {

    private final BoardJPARepository boardJPARepository;

    public BoardRepositoryImpl(BoardJPARepository boardJPARepository) {
        this.boardJPARepository = boardJPARepository;
    }

    @Override
    public Board create(Board board) {
        final var boardEntity = BoardEntity.fromDomain(board);
        final var savedBoardEntity = boardJPARepository.save(boardEntity);
        return savedBoardEntity.toDomain();
    }
}
