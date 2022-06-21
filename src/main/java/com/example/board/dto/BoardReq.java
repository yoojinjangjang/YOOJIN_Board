package com.example.board.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class BoardReq {
    private String title;
    private String content;

    @Builder
    public BoardReq(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "BoardReq{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
