package com.springcloud.board.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.springcloud.board.domain.board.AttachmentsEntity;
import com.springcloud.board.domain.board.BoardEntity;

public interface BoardEntityRepository extends MongoRepository<BoardEntity, String> {
	
//	@Query("{'company' :{'$ref' : 'company' , '$id' : ?0}}")
//	Company find(String companyId);
	//    @Query(value = "{'employees.name': ?0}", fields = "{'employees' : 0}")

	
    @Query(value="{ 'attachments.$id' : ?0 }")
    public Optional<BoardEntity> findByAttachmentsId(String id); 
    @Query(value="{ 'board.$id' : ?0 }")
    public Optional<BoardEntity> findByBoardId(String id); 
}