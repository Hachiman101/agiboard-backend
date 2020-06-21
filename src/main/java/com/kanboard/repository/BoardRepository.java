package com.kanboard.repository;

import com.kanboard.entity.Board;
import com.kanboard.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
    List<Board> findAllByBoardMembers(User user);
    Board findById(UUID id);
}
