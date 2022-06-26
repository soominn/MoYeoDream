package com.project.moyeodream.controller;

import com.project.moyeodream.domain.vo.StudyVO;
import com.project.moyeodream.service.StudyCommentService;
import com.project.moyeodream.service.StudyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/study/*")
public class StudyController {
    private final StudyService studyService;
    private final StudyCommentService studyCommentService;

    // 모든 스터디 목록
    @GetMapping("list")
    public void studyList(){}

    // 승인된 스터디 목록
    @GetMapping("approveList")
    public void studyApproveList(){}

    // 스터디 조회
    @GetMapping("read")
    public String read(int studyNumber, Model model) {
        log.info("----------------------------");
        log.info("read : " + studyNumber);
        log.info("----------------------------");
        model.addAttribute("study", studyService.read(studyNumber));
        return "/study/studyView";
    }

    // 스터디 수정용 조회
    @GetMapping("modify")
    public String modify(Integer studyNumber, Model model) {
        log.info("----------------------------");
        log.info("modify : " + studyNumber);
        log.info("----------------------------");
        model.addAttribute("study", studyService.modify(studyNumber));
        return "study/studyModify";
    }

    // 내가 만든 스터디 목록
    @GetMapping("createdList")
    public void studyCreateList(Integer memberNumber){}

    // 내가 참여 중인 스터디 목록
    @GetMapping("participationList")
    public void participationList(Integer memberNumber){}

    // 스터디 작성
    @PostMapping("register")
    public RedirectView register(StudyVO studyVO, HttpServletRequest req) {
        log.info("----------------------------");
        log.info("register : " + studyVO);
        log.info("----------------------------");

        // 원래
//        HttpSession session = req.getSession();
//        Integer memberNumber = (Integer)session.getAttribute("memberNumber");
//        studyVO.setStudyMemberNumber(memberNumber);

        studyVO.setStudyMemberNumber(1); // 테스트용

        studyService.register(studyVO);

        return new RedirectView("/study/read?studyNumber=" + studyVO.getStudyNumber());
    }

    // 스터디 수정
    @PostMapping("modify")
    public RedirectView modify(StudyVO studyVO, HttpServletRequest req) {
        log.info("----------------------------");
        log.info("modify : " + studyVO);
        log.info("----------------------------");

        // 원래
//        HttpSession session = req.getSession();
//        Integer memberNumber = (Integer)session.getAttribute("memberNumber");
//        studyVO.setStudyMemberNumber(memberNumber);

        studyVO.setStudyMemberNumber(1); // 테스트용

        studyService.modify(studyVO);

        return new RedirectView("/study/read?studyNumber=" + studyVO.getStudyNumber());
    }

    // 스터디 삭제
    @GetMapping("remove")
    public String remove(Integer studyNumber) {
        log.info("----------------------------");
        log.info("remove : " + studyNumber);
        log.info("----------------------------");

        studyService.remove(studyNumber);

        return register();
    }

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
    @GetMapping("register")
    public String register() {
        return "/study/studyCreate";
    }

    // 스터디 모집 상세보기
    @GetMapping("studyView")
    public void studyView() {}
}
