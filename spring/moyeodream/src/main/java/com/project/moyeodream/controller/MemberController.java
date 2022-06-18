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

    // 로그인

    // 내 정보 불러오기
    @GetMapping("read")
    public String myPage(Integer memberNumber){
        return "myPage/myPage";
    }

    // 내 정보 수정(post) => 미완성
    @PostMapping("modify")
    public String myProfile(MemberVO memberVO){
        return "myPage/myProfile";
    }

    // 탈퇴
}
