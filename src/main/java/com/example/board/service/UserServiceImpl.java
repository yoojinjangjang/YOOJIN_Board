package com.example.board.service;

import com.example.board.dto.UserDto;
import com.example.board.entity.User;
import com.example.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService{

    private final UserRepository userRepository;


    public User save(UserDto userDto) { //회원정보 데이터베이스 저장
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userDto.setPassword(encoder.encode(userDto.getPassword()));

        return userRepository.save(User.builder()
                .name(userDto.getName())
                .userId(userDto.getId())
                .birth(userDto.getYy()+userDto.getMm()+userDto.getDd())
                .password(userDto.getPassword()).build());

    }

    @Override
    public User loadUserByUsername(String id) throws UsernameNotFoundException {
        System.out.println(id);
        System.out.println(userRepository.findUserByUserId(id));
        return userRepository.findUserByUserId(id)
                .orElseThrow(() -> new UsernameNotFoundException((id)));
    }
}
