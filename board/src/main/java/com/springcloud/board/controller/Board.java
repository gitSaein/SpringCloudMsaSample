package com.springcloud.board.controller;

import com.springcloud.board.api.board.BoardForm;
import com.springcloud.board.domain.board.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class Board {

    private BoardService boardService;

    @Autowired
    public Board(BoardService boardService){
        this.boardService = boardService;
    }
	
    @GetMapping("/ping")
    public ResponseEntity<String> healthCheck() {
        log.info("###health check");

        boardService.post(BoardForm.builder().contents("test").location("test").build());
        return ResponseEntity.ok("pong");
    }


}
