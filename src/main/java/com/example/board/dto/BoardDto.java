package com.example.board.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardDto {
    private long id;
    private String title;
    private String writer;
    private String content;
    private LocalDate created;

    @Builder
    public BoardDto(long id,String title,String writer,String content,LocalDateTime created){
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.content = content;
        if(created==null){
            this.created = LocalDate.now();
        }else{
        this.created = created.toLocalDate();
        }
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", created=" + created +
                '}';
    }
}
