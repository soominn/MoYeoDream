package com.project.moyeodream.controller;

import com.project.moyeodream.domain.vo.InquiryCommentVO;
import com.project.moyeodream.domain.vo.PostCommentVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/inquirycomment/*")
public class InquiryCommentController {
    // 댓글 작성
    @PostMapping("register")
    public void inquiryCommentWrite(InquiryCommentVO inquiryCommentVO){ }

    // 댓글 수정
    @PostMapping("modify")
    public void inquiryCommentUpdate(InquiryCommentVO inquiryCommentVO){ }

    // 댓글 삭제
    @GetMapping("remove")
    public void inquiryCommentRemove(Integer inquiryCommentNumber){ }

    // 전체 댓글 목록 조회
    @GetMapping("list")
    public void inquiryComment(Integer inquiryCommentInquiryNumber){ }

    // 내 댓글 목록 조회
    @GetMapping("myList")
    public void myInquiryComment(Integer inquiryCommentMemberNumber){ }
}
