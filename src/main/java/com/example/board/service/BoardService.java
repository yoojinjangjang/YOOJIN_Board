package com.example.board.service;

import com.example.board.dto.BoardDto;
import com.example.board.dto.BoardReq;
import com.example.board.entity.Board;
import com.example.board.entity.User;
import com.example.board.repository.BoardRepository;
import com.example.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public List<BoardDto> getBoardLists() {
        List<BoardDto> boardList = new ArrayList<>();
        for (Board board : boardRepository.findAll()) {
            BoardDto boardDto = new BoardDto(
                    board.getId(),
                    board.getTitle(),
                    board.getUser().getUserId(),
                    board.getContent(),
                    board.getCreated()
            );
            boardList.add(boardDto);
        }
        return boardList;
    }

    public void saveBoard(BoardReq boardReq, String writer) {
        Board board = Board.builder()
                .user(userRepository.getById(writer))
                .title(boardReq.getTitle())
                .content(boardReq.getContent()).build();

        boardRepository.save(board);
    }

    public BoardDto getBoardDetail(long boardId) {
        Board board = boardRepository.getById(boardId);

        BoardDto boardDto = BoardDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .writer(board.getUser().getUserId())
                .created(board.getCreated())
                .content(board.getContent())
                .build();
        return boardDto;
    }

    public void delete(long boardId) {
        boardRepository.deleteById(boardId);
    }

    @Transactional
    public void modifyBoard(BoardDto boardDto) {

        Board board = boardRepository.getById(boardDto.getId());
        board.update(boardDto.getTitle(),boardDto.getContent());
        boardRepository.save(board);

    }
}