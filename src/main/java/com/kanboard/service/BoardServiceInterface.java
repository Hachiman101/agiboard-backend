package com.kanboard.service;

import com.kanboard.entity.Board;

import java.util.UUID;

public interface BoardServiceInterface {
    Board findById(UUID id);
}
