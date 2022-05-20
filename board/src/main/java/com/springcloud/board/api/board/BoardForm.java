package com.springcloud.board.api.board;

import com.springcloud.board.domain.board.BoardEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardForm {

    private String contents;
    private String location;

    @Builder
    public BoardForm(String contents,String location ){
        this.contents = contents;
        this.location = location;
    }

    public BoardEntity convertBoardEntity(){
        return BoardEntity.builder()
                .contents(this.contents)
                .location(this.location)
                .build();
    }
}
