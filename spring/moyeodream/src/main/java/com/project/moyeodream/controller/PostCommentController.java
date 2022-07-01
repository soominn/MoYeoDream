package com.project.moyeodream.controller;

import com.project.moyeodream.domain.vo.PostCommentVO;
import com.project.moyeodream.service.PostCommentServiceImpl;
import com.project.moyeodream.service.PostServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/postReply/*")
public class PostCommentController {

    private final PostCommentServiceImpl postCommentService;

    // 댓글 작성
    @PostMapping("register")
    public void register(@RequestBody PostCommentVO postCommentVO, HttpServletRequest req){
        log.info("---------------------------------------");
        log.info("reply register Controller......");
        log.info("---------------------------------------");

        // 세션에서 작성자 정보 받아오기
        HttpSession session = req.getSession();
        postCommentVO.setPostCommentMemberNumber((Integer)session.getAttribute("memberNumber"));
        log.info("작성자 memberNum : "+postCommentVO.getPostCommentMemberNumber());

        postCommentService.registerReply(postCommentVO);
        log.info(postCommentVO.getPostCommentNumber() + "번 댓글 등록 성공");
    }

    // 댓글 수정
    @PostMapping("modify")
    public boolean modify(@RequestBody PostCommentVO postCommentVO){
        log.info("---------------------------------------");
        log.info("reply modify Controller......");
        log.info("---------------------------------------");

        log.info(postCommentVO.getPostCommentNumber() + "번 댓글 수정 성공");
        return postCommentService.modifyReply(postCommentVO);
    }

    // 댓글 삭제
    @DeleteMapping("remove/{postCommentNumber}")
    public boolean remove(@PathVariable Integer postCommentNumber){
        log.info("---------------------------------------");
        log.info("reply remove Controller......");
        log.info("---------------------------------------");

        log.info(postCommentNumber+"번 댓글 삭제 성공");
        return postCommentService.removeReply(postCommentNumber);
    }

    // 전체 댓글 목록 조회
    @GetMapping("list/{postNumber}")
    public List<PostCommentVO> getList(@PathVariable Integer postNumber, HttpServletRequest req){
        log.info("---------------------------------------");
        log.info("reply getList Controller......");
        log.info("---------------------------------------");

        log.info("가져온 list : " +
                postCommentService.getReplyList(postNumber));

        return postCommentService.getReplyList(postNumber);
    }

//    // 댓글 내용 검색
//    @GetMapping("list/{keyword}")
//    public List<PostCommentVO> getList(@PathVariable String keyword){
//        log.info("---------------------------------------");
//        log.info("reply getList Controller......");
//        log.info("---------------------------------------");
//
//        log.info("가져온 list : " +
//                postCommentService.getReplyList(postNumber));
//
//        return postCommentService.getReplyList(postNumber);
//    }

    // 전체 댓글 개수
    @GetMapping("total/{postNumber}")
    public Integer getTotal(@PathVariable Integer postNumber){
        log.info("---------------------------------------");
        log.info("reply getTotal Controller......");
        log.info("---------------------------------------");

        log.info(postNumber+"번 댓글 개수 : "
                + postCommentService.getReplyTotal(postNumber));
        return postCommentService.getReplyTotal(postNumber);
    }

    // 내 댓글 목록 조회
    @GetMapping("myList/{memberNumber}")
    public List<PostCommentVO> myList(@PathVariable Integer memberNumber){
        log.info("---------------------------------------");
        log.info("reply mytList Controller......");
        log.info("---------------------------------------");

        log.info("가져온 list : " +
                postCommentService.myList(memberNumber));

        return postCommentService.myList(memberNumber);
    }
}
