package com.kanboard.service;

import com.kanboard.entity.Board;
import com.kanboard.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BoardServiceInterfaceImpl implements BoardServiceInterface {

    final BoardRepository boardRepository;

    @Autowired
    public BoardServiceInterfaceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public Board findById(UUID id) {
        return boardRepository.findById(id);
    }
}
