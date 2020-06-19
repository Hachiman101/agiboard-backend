package com.kanboard.repository;

import com.kanboard.entity.BoardColumn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColumnRepository extends JpaRepository<BoardColumn, Integer> {
}
