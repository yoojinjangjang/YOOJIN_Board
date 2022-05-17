package com.example.board.dto;

import lombok.Data;

@Data
public class UserDto {
    private String id;
    private String name;
    private String password;
    private String role;
    private String yy;
    private String mm;
    private String dd;

    @Override
    public String toString() {
        return "UserDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", yy='" + yy + '\'' +
                ", mm='" + mm + '\'' +
                ", dd='" + dd + '\'' +
                '}';
    }
}
