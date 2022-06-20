package com.project.moyeodream.controller;

import com.project.moyeodream.domain.vo.PostVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/post/*")
public class PostController {

    // 모든 자유 게시판 목록
    @GetMapping("list")
    public void postList(){}

    // 자유 게시판 조회
    @GetMapping("read")
    public void postRead(Integer boardNumber){}

    // 카테고리별 자유 게시판 조회
    @GetMapping("readCategory")
    public void readCategory(String postCategory){}

    // 내 자유 게시판 글 확인
    @GetMapping("myPost")
    public void myPost(Integer memberNumber){}

    // 자유게시판 작성
    @PostMapping("register")
    public void postRegister(PostVO postVO){}

    // 자유게시판 수정
    @PostMapping("modify")
    public void postModify(PostVO postVO){}

    // 자유게시판 삭제
    @GetMapping("remove")
    public void postRemove(PostVO postVO){}

    // --- 프론트 ---

    // 게시판 메인
    @GetMapping("board")
    public String board(){ return "board/board";}

    // 게시판 세부사항
    @GetMapping("boardDetail")
    public String boardDetail(){ return "board/boardDetail";}

    // 게시판 글쓰기
    @GetMapping("boardWrite")
    public String boardWrite(){ return "board/boardWrite";}
}
