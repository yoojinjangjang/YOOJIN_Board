package com.example.board.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

//조회시 사용하는 dto
@Data
public class CommentDto {

    private long id;
    private String userId;
    private String content;
    private LocalDateTime created;
    private LocalDateTime updated;

    @Builder
    public CommentDto(long id, String userId, String content, LocalDateTime created,
            LocalDateTime updated) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.created = created;
        this.updated = updated;
    }
}
