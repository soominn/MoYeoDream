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
@RequestMapping("/admin/*")
public class AdminController {

    // 관리자 로그인
    @PostMapping("login")
    public int adminLogin(MemberVO memberVO){
        return memberVO.getMemberNumber();
    }


    // ---- 프론트 ----

    // admin 메인
    @GetMapping("adminMain")
    public void adminMain(){}

    // admin 관리자
    @GetMapping("adminNav")
    public void adminNav(){}

    // admin 채용공고 관리
    @GetMapping("adminPostManage")
    public void adminPostManage(){}

    // admin 채용공고 상세보기
    @GetMapping("adminPostView")
    public void adminPostView(){}

    // admin QnA 관리
    @GetMapping("adminQnaManage")
    public void adminQnaManage(){}

    // admin QnA 상세보기
    @GetMapping("adminQnaView")
    public void adminQnaView(){}

    // admin 스터디 관리
    @GetMapping("adminStudyManage")
    public void adminStudyManage(){}

    // admin 스터디 상세보기
    @GetMapping("adminStudyView")
    public void adminStudyView(){}


}
