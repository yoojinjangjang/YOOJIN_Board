package com.example.board.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@NoArgsConstructor
public class User extends BaseTimeEntity implements UserDetails {
    @Id
    @Column(name="user_id")
    private String userId;

    private String name;

    private String password;

    private String birth;

    private String role;

    @OneToMany(mappedBy = "user")
    private List<Board> boards;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    @Builder
    public User(String userId, String name, String password, String birth){
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.birth = birth;
        this.role = "ROLE_USER";
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> roles = new HashSet<>();
        for(String r: role.split(",")){
            roles.add(new SimpleGrantedAuthority(r));
        }
        return roles;
    }

    @Override
    public String getUsername() {
        return userId;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
