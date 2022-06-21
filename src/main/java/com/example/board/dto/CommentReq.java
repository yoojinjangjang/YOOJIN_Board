package com.example.board.dto;

import lombok.Data;

// 작성시 사용하는 dto
@Data
public class CommentReq {
    private long id;
    private String userId;
    private String content;

    public CommentReq(long id, String userId, String content) {
        this.id = id;
        this.userId = userId;
        this.content = content;
    }
}
