package com.springcloud.board.domain.board;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Document(collection = "database_sequences")
@Getter
public class DatabaseSequence {

    @Id
    private String id;

    private long seq;

}