package com.springcloud.board;

import com.springcloud.board.domain.board.BoardEntity;
import com.springcloud.board.repository.BoardEntityRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@MockBean(JpaMetamodelMappingContext.class)
//@EnableJpaAuditing
@SpringBootTest
class BoardApplicationTests {

	@Autowired
	BoardEntityRepository repository;

	@Test
	void BoardEntitySaveTest() {
		repository.save(BoardEntity.builder()
				.contents("test2")
				.location("test2")
				.build());
	}
}
