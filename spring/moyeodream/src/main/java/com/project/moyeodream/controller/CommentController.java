package com.project.moyeodream.controller;

import com.project.moyeodream.domain.vo.CommentVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/comment/*")
public class CommentController {
    // 댓글 작성
    @PostMapping("register")
    public void commentWrite(CommentVO commentVO){ }

    // 댓글 수정
    @PostMapping("modify")
    public void commentUpdate(CommentVO commentVO){ }

    // 댓글 삭제
    @GetMapping("remove")
    public void commentRemove(Integer commentNumber){ }

    // 내 댓글 목록
    @GetMapping("list")
    public void myComment(Integer postNumber){ }
}
