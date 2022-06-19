package com.project.moyeodream.controller;

import com.project.moyeodream.domain.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/member/*")
public class MemberController {

    // 회원가입
    @PostMapping("join")
    public void memberJoin(MemberVO memberVO){}

    // 로그인
    @PostMapping("login")
    public void memberLogin(Integer userNumber){}

    // 내 정보 불러오기
    @GetMapping("read")
    public void myPageRead(Integer memberNumber){}

    // 내 정보 수정(post)
    @PostMapping("modify")
    public void myProfileModify(MemberVO memberVO){}

    // 탈퇴
    @GetMapping("remove")
    public void memberRemove(Integer memberNumber){}

    // ----- 프론트 -----

    // 메인
    @GetMapping("main")
    public String main(){ return "main"; }

    // 내 정보
    @GetMapping("myPage")
    public String myPage(){ return "myPage/myPage"; }

    // 내 정보수정
    @GetMapping("myProfile")
    public String myProfile(){ return "myPage/myProfile"; }

    // 내 스터디
    @GetMapping("myStudy")
    public String myStudy(){ return "myPage/myStudy"; }

    //내 게시글
    @GetMapping("myPost")
    public String myPost(){ return "myPage/myPost"; }

    //내 댓글
    @GetMapping("myComment")
    public String myComment(){ return "myPage/myComment"; }
}
