package com.springcloud.board;

import com.springcloud.board.domain.board.AttachmentsEntity;
import com.springcloud.board.domain.board.BoardEntity;
import com.springcloud.board.enums.AttachmentType;
import com.springcloud.board.repository.AttachmentEntityRepository;
import com.springcloud.board.repository.BoardEntityRepository;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@MockBean(JpaMetamodelMappingContext.class)
//@EnableJpaAuditing
@SpringBootTest
@Slf4j
class BoardApplicationTests {

	@Autowired
	BoardEntityRepository boardRepository;
	@Autowired
	AttachmentEntityRepository attachmentRepository;

	@Test
	void BoardEntitySaveTest() {
		
		List<AttachmentsEntity> dd = new ArrayList<>();
		dd.add(AttachmentsEntity.builder()
				.attachmentType(AttachmentType.PHOTO)
				.build());
				
		BoardEntity boardEntity = boardRepository.save(BoardEntity.builder()
				.contents("test2")
				.location("test2")
				.attachments(dd)
				.build());
		Optional<BoardEntity> isBoard = boardRepository.findById(boardEntity.get_id());
		
		isBoard.ifPresent(k->{
			log.info(k.toString());
		});
	}
	
	@Test
	void AttachmentsEntitySaveTest() {
		attachmentRepository.save(AttachmentsEntity.builder()
				.attachmentType(AttachmentType.PHOTO)
				.build());
	}
}
