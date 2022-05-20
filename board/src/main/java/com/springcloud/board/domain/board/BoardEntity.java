package com.springcloud.board.domain.board;

import com.springcloud.board.domain.BaseEntity;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;


@Getter
@Entity
@Document(collection = "boards")
@NoArgsConstructor
public class BoardEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id", nullable = false)
    private Long id;

    @Setter
    private String contents;
    @Setter
    private String location;


    @Builder
    public BoardEntity(String contents, String location){
        this.contents = contents;
        this.location= location;
    }

}
