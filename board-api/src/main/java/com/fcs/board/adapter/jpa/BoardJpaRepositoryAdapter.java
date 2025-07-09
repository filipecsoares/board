package com.fcs.board.adapter.jpa;

import com.fcs.board.adapter.jpa.entities.BoardEntity;
import com.fcs.board.adapter.jpa.mapper.BoardMapper;
import com.fcs.board.application.ports.BoardRepository;
import com.fcs.board.domain.Board;
import com.fcs.board.adapter.jpa.repositories.BoardJpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class BoardJpaRepositoryAdapter implements BoardRepository {
    private final BoardJpaRepository jpaRepository;

    public BoardJpaRepositoryAdapter(BoardJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Board save(Board board) {
        BoardEntity entity = BoardMapper.toEntity(board);
        BoardEntity saved = jpaRepository.save(entity);
        return BoardMapper.toDomain(saved);
    }

    @Override
    public Optional<Board> findById(Long id) {
        return jpaRepository.findById(id).map(BoardMapper::toDomain);
    }

    @Override
    public List<Board> findAll() {
        return jpaRepository.findAll().stream().map(BoardMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
