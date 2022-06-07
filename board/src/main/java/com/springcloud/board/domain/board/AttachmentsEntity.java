package com.springcloud.board.domain.board;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.springcloud.board.domain.BaseEntity;
import com.springcloud.board.enums.AttachmentType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "attachments")
public class AttachmentsEntity extends BaseEntity {
	
	public static final String SEQUENCE_NAME = "attachments_sequence";

	@Id
	private String id;
	private String postId;
	private String categoryId;
	private AttachmentType attachmentType;
	private String path;
}
