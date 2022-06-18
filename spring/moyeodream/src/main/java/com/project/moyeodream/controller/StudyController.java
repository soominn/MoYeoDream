package com.project.moyeodream.controller;

import com.project.moyeodream.domain.vo.StudyVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/study/*")
public class StudyController {

    // 모든 스터디 목록


    // 승인된 스터디 목록

    // 스터디 조회
    @GetMapping("read")
    public String studyView(Integer studyNumber){
        return "study/studyView";
    }

    // 내가 만든 스터디 목록
    @GetMapping("createdList")
    public String createList(Integer memberNumber){
        return "myPage/myStudy";
    }

    // 내가 참여 중인 스터디 목록
    @GetMapping("participationList")
    public String participationList(Integer memberNumber){
        return "myPage/myStudy";
    }

    // 스터디 상세보기


    // 스터디 작성(Post) => 미완성
   @PostMapping("register")
    public String studyCreate(StudyVO studyVO){
       return "study/studyCreate";
   }

    // 스터디 수정

    // 스터디 삭제

    // 카테고리별 스터디

    // 스터디 승인

    // 스터디 거절

}
