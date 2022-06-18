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
    @GetMapping("list")
    public void studyList(){}

    // 승인된 스터디 목록
    @GetMapping("approveList")
    public void studyApproveList(){}

    // 스터디 조회
    @GetMapping("read")
    public void studyRead(Integer studyNumber){}

    // 내가 만든 스터디 목록
    @GetMapping("createdList")
    public void studyCreateList(Integer memberNumber){ }

    // 내가 참여 중인 스터디 목록
    @GetMapping("participationList")
    public void participationList(Integer memberNumber){}

    // 스터디 작성(Post)
   @PostMapping("register")
    public void studyRegister(StudyVO studyVO){}

    // 스터디 수정
    @PostMapping("modify")
    public void studyModify(StudyVO studyVO){}

    // 스터디 삭제
    @GetMapping("remove")
    public void studyRemove(Integer studyNumber){}

    // 카테고리별 스터디
    @GetMapping("categoryList")
    public void studyCate(String studyCategory){}

    // 스터디 승인
    @GetMapping("approve")
    public void studyApprove(Integer studyNumber){}

    // 스터디 거절
    @GetMapping("refuse")
    public void studyRefuse(Integer studyNumber){}

    // 스터디 모집 작성
    @GetMapping("studyCreate")
    public void studyCreate() {}

    // 스터디 모집 상세보기
    @GetMapping("studyView")
    public void studyView() {}
}
