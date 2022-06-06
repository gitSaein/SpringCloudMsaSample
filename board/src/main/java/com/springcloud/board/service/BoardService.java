package com.springcloud.board.service;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcloud.board.api.BoardForm;
import com.springcloud.board.domain.board.BoardEntity;
import com.springcloud.board.repository.BoardEntityRepository;

//@Service
//@RequiredArgsConstructor
public class BoardService {

	@Autowired
    private BoardEntityRepository boardEntityRepository;

    public BoardEntity post(BoardForm boardForm){
        return boardEntityRepository.save(boardForm.convertBoardEntity());
    }
}
