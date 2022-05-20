package com.springcloud.board.domain.board;

import com.springcloud.board.api.board.BoardForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    private BoardEntityRepository boardEntityRepository;

    @Autowired
    public BoardService(BoardEntityRepository boardEntityRepository){
        this.boardEntityRepository = boardEntityRepository;
    }

    public BoardEntity post(BoardForm boardForm){
        return boardEntityRepository.save(boardForm.convertBoardEntity());
    }
}
