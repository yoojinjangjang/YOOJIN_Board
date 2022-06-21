package com.example.board.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Board extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    private String title;

    private String content;

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", user=" + user.toString() +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    @Builder
    public Board(User user,String title,String content){
        this.user = user;
        this.title = title;
        this.content = content;
    }
}
