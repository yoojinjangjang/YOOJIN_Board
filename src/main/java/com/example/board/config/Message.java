package com.example.board.config;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Message {
    String message = "";
    String href = "";

    @Builder
    public Message(String message,String href){
        this.message = message;
        this.href = href;
    }
}
