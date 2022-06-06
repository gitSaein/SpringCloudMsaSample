package com.springcloud.board.controller;

import com.springcloud.board.api.BoardForm;
import com.springcloud.board.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//@Slf4j
//@RestController
//@RequiredArgsConstructor
public class BoardController {

//	@Autowired
//    private BoardService boardService;
//	
//    @GetMapping("/ping")
//    public ResponseEntity<String> healthCheck() {
//        log.info("###health check");
//
//        boardService.post(BoardForm.builder().contents("test").location("test").build());
//        return ResponseEntity.ok("pong");
//    }


}
