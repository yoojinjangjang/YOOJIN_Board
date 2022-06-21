package com.example.board.controller;

import com.example.board.config.Message;
import com.example.board.dto.BoardDto;
import com.example.board.dto.BoardReq;
import com.example.board.entity.Comment;
import com.example.board.service.BoardService;
import com.example.board.service.CommentService;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    private final CommentService commentService;

    @PostMapping("/board")
    public ModelAndView board(Principal principal,BoardReq boardReq, ModelAndView mav){
        boardService.saveBoard(boardReq,principal.getName());
        mav.addObject("data",new Message("게시글이 등록되었습니다.","/"));
        mav.setViewName("message");

        return mav;


    }

    @GetMapping("/board")
    public String getBoard(){
        return "/board";
    }

    // 게시글 상세화면 controller
    @GetMapping("/detail")
    public String detail(Model model,@RequestParam long boardId){
        //게시글 상세정보 불러오기
        BoardDto boardDto = boardService.getBoardDetail(boardId);
        //댓글 목록 불러오기
        List<Comment> comments =   commentService.getCommentList(boardId);
        model.addAttribute("board",boardDto);
        model.addAttribute("comments",comments);
        return "/detailBoard";
    }

    // 게시글 삭제
    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam long boardId,ModelAndView mav){
        boardService.delete(boardId);
        mav.addObject("data",new Message("게시글이 삭제되었습니다.","/"));
        mav.setViewName("message");
        return mav;
    }

    // 게시글 수정 페이지 전환
    @GetMapping("/modify")
    public String modify(@RequestParam long boardId,Model model){
        BoardDto boardDto = boardService.getBoardDetail(boardId);
        model.addAttribute("board",boardDto);
        return "/modifyBoard";
    }

    // 게시글 수정 로직
    @PostMapping("/modify")
    public ModelAndView modifyBoard(BoardDto boardDto,ModelAndView mav){
        boardService.modifyBoard(boardDto);
        mav.addObject("data",new Message("게시글이 수정되었습니다.",
                "/detail?boardId="+boardDto.getId()));
        mav.setViewName("message");
        return mav;
    }



}
