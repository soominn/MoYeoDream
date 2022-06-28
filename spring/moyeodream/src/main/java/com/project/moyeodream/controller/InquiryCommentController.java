package com.project.moyeodream.controller;

import com.project.moyeodream.domain.vo.InquiryCommentVO;
import com.project.moyeodream.domain.vo.StudyCommentDTO;
import com.project.moyeodream.service.InquiryCommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/inquirycomment/*")
@RequiredArgsConstructor
public class InquiryCommentController {
    private final InquiryCommentService inquiryCommentService;

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
    @GetMapping("/list/{inquiryNumber}")
    public List<InquiryCommentVO> inquiryComment(@PathVariable("inquiryNumber") int inquiryNumber){
        log.info("getList........... : " + inquiryNumber);
        return inquiryCommentService.inquiryCommentList(inquiryNumber);
    }

}
