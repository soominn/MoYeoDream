package com.project.moyeodream.controller;

import com.project.moyeodream.domain.vo.JobpostingVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/jobPosting/*")
public class JobPostingController {

    //    모든 채용 공고 목록
    @GetMapping("list")
    public void jobPostList(){}

    //    승인된 채용 공고 목록
    @GetMapping("approveList")
    public void jobPostApprove(){}

    //    채용 공고 조회
    @GetMapping("read")
    public void jobPostRead(Integer jobPostingNumber){}

    //    채용 공고 작성
    @PostMapping("register")
    public void jobPostRegister(JobpostingVO jobpostingVO){}

    //    채용 공고 수정
    @PostMapping("modify")
    public void jobPostModify(JobpostingVO jobpostingVO){}

    //    채용 공고 삭제
    @GetMapping("remove")
    public void jobPostRemove(Integer jobPostingNumber){}

    //    채용 공고 승인
    @GetMapping("approve")
    public void jobPostApprove(Integer jobPostingNumber){}

    //    채용 공고 거절
    @GetMapping("refuse")
    public void jobPostRefuse(Integer jobPostingNumber){}

    // ----- 프론트 -----

    // 채용 공고 작성
    @GetMapping("jobPostingCreate")
    public void jobPostingCreate() {}

    // 채용 공고 상세보기
    @GetMapping("jobPostingView")
    public void jobPostingView() {}
}
