package com.springcloud.board.domain.board;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardEntityRepository extends MongoRepository<BoardEntity, Long> {
}