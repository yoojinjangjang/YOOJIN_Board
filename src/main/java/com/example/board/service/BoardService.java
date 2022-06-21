package com.example.board.service;

import com.example.board.dto.BoardDto;
import com.example.board.entity.Board;
import com.example.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public List<BoardDto> getBoardLists(){
        List<BoardDto> boardList = new ArrayList<>();
        for (Board board : boardRepository.findAll()) {
            BoardDto boardDto = new BoardDto(
                    board.getId(),
                    board.getTitle(),
                    board.getUser().getUserId(),
                    board.getCreated()
            );
            boardList.add(boardDto);
        }
        return boardList;
    }
}
