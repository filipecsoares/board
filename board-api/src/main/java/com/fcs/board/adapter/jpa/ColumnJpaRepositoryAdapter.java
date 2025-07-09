package com.fcs.board.adapter.jpa;

import com.fcs.board.adapter.jpa.entities.ColumnEntity;
import com.fcs.board.adapter.jpa.mapper.ColumnMapper;
import com.fcs.board.application.ports.ColumnRepository;
import com.fcs.board.domain.Column;
import com.fcs.board.adapter.jpa.repositories.ColumnJpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ColumnJpaRepositoryAdapter implements ColumnRepository {
    private final ColumnJpaRepository jpaRepository;

    public ColumnJpaRepositoryAdapter(ColumnJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Column save(Column column) {
        ColumnEntity entity = ColumnMapper.toEntity(column);
        ColumnEntity saved = jpaRepository.save(entity);
        return ColumnMapper.toDomain(saved);
    }

    @Override
    public Optional<Column> findById(Long id) {
        return jpaRepository.findById(id).map(ColumnMapper::toDomain);
    }

    @Override
    public List<Column> findByBoardId(Long boardId) {
        return jpaRepository.findByBoardId(boardId)
                .stream()
                .map(ColumnMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
