package com.springcloud.board.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springcloud.board.domain.board.AttachmentsEntity;

public interface AttachmentEntityRepository extends MongoRepository<AttachmentsEntity, String> {
}
