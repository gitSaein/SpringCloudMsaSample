package com.springcloud.board.domain.board;

import com.springcloud.board.domain.BaseEntity;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "board")
public class BoardEntity extends BaseEntity {

	@Transient
	public static final String SEQUENCE_NAME = "board_sequence";
	
    @Id
    private String _id;

    private String contents;
    private String location;

}
