package com.kanboard.controller;

import com.kanboard.entity.Board;
import com.kanboard.entity.User;
import com.kanboard.service.BoardServiceInterface;
import com.kanboard.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/api/boards")
public class BoardController {

    final UserServiceInterface userServiceInterface;
    final BoardServiceInterface boardServiceInterface;

    @Autowired
    public BoardController(UserServiceInterface userServiceInterface, BoardServiceInterface boardServiceInterface) {
        this.userServiceInterface = userServiceInterface;
        this.boardServiceInterface = boardServiceInterface;
    }

    @GetMapping
    public ResponseEntity<ArrayList<Board>> getAllBoardsForUser(@RequestParam("username") String username) {
        User user = userServiceInterface.findOne(username);
        Set<Board> boards = user.getBoardsMember();

        ArrayList<Board> sortedBoards = new ArrayList<>(boards);
        sortedBoards.sort((board1, board2) -> board1.getName().compareToIgnoreCase(board2.getName()));
        return ResponseEntity.status(200).body(sortedBoards);
    }
}
