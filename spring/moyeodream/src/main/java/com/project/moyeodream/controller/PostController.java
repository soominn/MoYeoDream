package com.project.moyeodream.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/post/*")
public class PostController {

    // 모든 자유 게시판 목록

    // 자유 게시판 조회


    // 내 자유 게시판 글 확인
    @GetMapping("myPost")
    public String myPost(Integer memberNumber){
        return "myPage/myPost";
    }

    // 자유게시판 작성

    // 자유게시판 수정

    // 자유게시판 삭제

}
