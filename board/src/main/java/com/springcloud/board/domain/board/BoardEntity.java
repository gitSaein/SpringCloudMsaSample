package com.springcloud.board.domain.board;

import com.springcloud.board.domain.BaseEntity;
import lombok.*;

import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

import javax.persistence.*;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "board")
public class BoardEntity extends BaseEntity {

	@Transient
	public static final String SEQUENCE_NAME = "board_sequence";
	
    @Id
    private String _id;

    private String contents;
    private String location;
    @DBRef(lazy = true)    
    @ReadOnlyProperty
    private List<AttachmentsEntity> attachments;

}
