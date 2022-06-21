package com.example.board.service;

import com.example.board.dto.BoardReq;
import com.example.board.entity.Comment;
import com.example.board.repository.BoardRepository;
import com.example.board.repository.CommentRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    public List<Comment> getCommentList(long boardId) {
        List<Comment> comments = boardRepository.getById(boardId).getComments();
        return comments;
    }
}
