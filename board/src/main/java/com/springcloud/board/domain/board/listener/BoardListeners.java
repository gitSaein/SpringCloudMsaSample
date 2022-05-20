package com.springcloud.board.domain.board.listener;

import com.springcloud.board.domain.board.BoardEntity;

import javax.persistence.EntityListeners;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@EntityListeners(value = BoardListeners.class)
public class BoardListeners {

    @PrePersist
    public void onPrePersist(Object obj){
        if(obj instanceof BoardEntity) {
            var now = LocalDateTime.now();
            ((BoardEntity) obj).setCreateDate(now);
            ((BoardEntity) obj).setModifiedDate(now);
        }
    }

    @PreUpdate
    public void onPreUpdate(Object obj){
        if(obj instanceof BoardEntity) {
            ((BoardEntity) obj).setModifiedDate(LocalDateTime.now());
        }
    }

}
