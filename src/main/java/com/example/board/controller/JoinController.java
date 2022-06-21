package com.example.board.controller;

import com.example.board.dto.BoardDto;
import com.example.board.dto.UserDto;
import com.example.board.entity.Board;
import com.example.board.service.BoardService;
import com.example.board.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class JoinController {

    private final UserServiceImpl userService;
    private final BoardService boardService;
    @PostMapping("/join")
    public String join(Model model,UserDto user){
        model.addAttribute("user",user);
        userService.save(user);

        return "redirect:/login";
    }
    @GetMapping("/join")
    public String joinPage(){
        return "/join";
    }
    @GetMapping("/login")
    public String loginPage(){
        return "/login";
    }


    @GetMapping("/")
    public String main(Model model){
        List<BoardDto> boardList = boardService.getBoardLists();
        model.addAttribute("boards",boardList);
        return "/main";
    }

    @GetMapping("/logout")
    public String logoutPage(HttpServletRequest request,HttpServletResponse response){
        new SecurityContextLogoutHandler().logout(request,response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }

}
