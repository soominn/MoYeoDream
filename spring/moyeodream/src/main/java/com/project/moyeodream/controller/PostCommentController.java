package com.project.moyeodream.controller;

import com.project.moyeodream.domain.vo.PostCommentVO;
import com.project.moyeodream.service.PostCommentServiceImpl;
import com.project.moyeodream.service.PostServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/postReply/*")
public class PostCommentController {

    private final PostCommentServiceImpl postCommentService;

    // 댓글 작성
    @PostMapping("register")
    public void register(@RequestBody PostCommentVO postCommentVO){
        log.info("---------------------------------------");
        log.info("reply register Controller......");
        log.info("---------------------------------------");

        postCommentService.registerReply(postCommentVO);
        log.info(postCommentVO.getPostCommentNumber() + "번 댓글 등록 성공");
    }

    // 댓글 수정
    @PostMapping("modify")
    public void modify(@RequestBody PostCommentVO postCommentVO){
        log.info("---------------------------------------");
        log.info("reply modify Controller......");
        log.info("---------------------------------------");

        postCommentService.modifyReply(postCommentVO);
        log.info(postCommentVO.getPostCommentNumber() + "번 댓글 수정 성공");
    }

    // 댓글 삭제
    @GetMapping("remove/{postCommentNumber}")
    public String remove(@PathVariable Integer postCommentNumber){
        log.info("---------------------------------------");
        log.info("reply remove Controller......");
        log.info("---------------------------------------");

        postCommentService.removeReply(postCommentNumber);
        return postCommentNumber+"번 댓글 삭제 성공";
    }

    // 전체 댓글 목록 조회
    @GetMapping("list/{postNumber}")
    public void getList(@PathVariable Integer postNumber){
        log.info("---------------------------------------");
        log.info("reply getList Controller......");
        log.info("---------------------------------------");

        log.info("가져온 list : " +
                postCommentService.getReplyList(postNumber));
    }

    // 전체 댓글 개수
    @GetMapping("total/{postNumber}")
    public void getTotal(@PathVariable Integer postNumber){
        log.info("---------------------------------------");
        log.info("reply getTotal Controller......");
        log.info("---------------------------------------");

        log.info(postNumber+"번 댓글 개수 : "
                + postCommentService.getReplyTotal(postNumber));
    }

    // 내 댓글 목록 조회
    @GetMapping("myList/{memberNumber}")
    public void myList(@PathVariable Integer memberNumber){
        log.info("---------------------------------------");
        log.info("reply mytList Controller......");
        log.info("---------------------------------------");

        log.info("가져온 list : " +
                postCommentService.myList(memberNumber));
    }
}
