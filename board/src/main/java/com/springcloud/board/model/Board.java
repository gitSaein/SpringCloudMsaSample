package com.springcloud.board.model;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Document("boards")
@Getter
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String userId;
    private String contents;
    private String location;
    @CreatedDate
    private String createDate;
    @LastModifiedDate
    private String modifiedDate;

    @PrePersist
    public void onPrePersist(){
        this.createDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/mm/dd HH:mm:ss"));
        this.modifiedDate = this.createDate;
    }

    @PreUpdate
    public void onPreUpdate(){
        this.modifiedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/mm/dd HH:mm:ss"));
    }

    public Board(String id, String userId, String contents, String location, String createDate, String modifiedDate){
        super();

        this.id = id;
        this.userId = userId;
        this.contents = contents;
        this.location = location;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }
}
