package com.springcloud.board.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springcloud.board.domain.board.BoardEntity;

public interface BoardEntityRepository extends MongoRepository<BoardEntity, String> {
}