package com.project.moyeodream.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/comment/*")
public class CommentController {
    // 댓글 작성

    // 댓글 수정

    // 댓글 삭제

    // 내 댓글 목록
    @GetMapping("list")
    public String myComment(Integer postNumber){
        return "myPage/myComment";
    }
}
