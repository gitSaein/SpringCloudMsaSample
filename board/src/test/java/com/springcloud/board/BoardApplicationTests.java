package com.springcloud.board;

import com.springcloud.board.domain.board.BoardEntity;
import com.springcloud.board.domain.board.BoardEntityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;

@MockBean(JpaMetamodelMappingContext.class)
@SpringBootTest
class BoardApplicationTests {

	@Autowired
	BoardEntityRepository boardRepository;

	@Test
	void insertTest() {
		BoardEntity boardEntity = new BoardEntity();
		boardEntity.setContents("test");
		boardEntity.setLocation("test");

		boardRepository.save(boardEntity);
	}

}
