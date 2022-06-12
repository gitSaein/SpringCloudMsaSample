package com.springcloud.board.repository;

import com.springcloud.board.domain.board.AttachmentsEntity;
import com.springcloud.board.domain.board.BoardEntity;
import com.springcloud.board.enums.AttachmentType;
import com.springcloud.board.repository.AttachmentEntityRepository;
import com.springcloud.board.repository.BoardEntityRepository;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@MockBean(JpaMetamodelMappingContext.class)
//@EnableJpaAuditing
@SpringBootTest
//@DataJpaTest
@Slf4j
class BoardApplicationTests {

	@Autowired
	BoardEntityRepository boardRepository;
	@Autowired
	AttachmentEntityRepository attachmentRepository;

	@Test
	@DisplayName("BoardEntity save and ref'Find ")
	void BoardEntitySaveTest() {
		
		List<AttachmentsEntity> attachList = List.of(
				AttachmentsEntity.builder()
				.attachmentType(AttachmentType.PHOTO)
				.build(),
				AttachmentsEntity.builder()
				.attachmentType(AttachmentType.PHOTO)
				.build());
		List<AttachmentsEntity> attachments = attachmentRepository.saveAll(attachList);
		BoardEntity boardEntity = boardRepository.save(BoardEntity.builder()
				.contents("test2")
				.location("test2")
				.attachments(attachments)
				.build());

		Optional<BoardEntity> isBoard = boardRepository.findById(boardEntity.getId());
	
		Assertions.assertEquals(isBoard.get().getAttachments().size(), boardEntity.getAttachments().size());
		
		 
	}
	
	@Test
	void AttachmentsEntitySaveTest() {
//		attachmentRepository.save(AttachmentsEntity.builder()
//				.attachmentType(AttachmentType.PHOTO)
//				.build());
	}
}
