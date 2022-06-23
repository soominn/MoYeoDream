package com.project.moyeodream.controller;

import com.project.moyeodream.domain.vo.StudyVO;
import com.project.moyeodream.service.StudyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/study/*")
public class StudyController {
    private final StudyService studyService;

    // 모든 스터디 목록
    @GetMapping("list")
    public void studyList(){}

    // 승인된 스터디 목록
    @GetMapping("approveList")
    public void studyApproveList(){}

    // 스터디 조회
    @GetMapping("read")
    public String read(Integer studyNumber, Integer studyMemberNumber, Model model) {
        log.info("----------------------------");
        log.info("studyRead............. : " + studyMemberNumber);
        log.info("----------------------------");
        model.addAttribute("study", studyService.read(studyNumber, studyMemberNumber));
        return "/study/studyView";
    }

    // 내가 만든 스터디 목록
    @GetMapping("createdList")
    public void studyCreateList(Integer memberNumber){}

    // 내가 참여 중인 스터디 목록
    @GetMapping("participationList")
    public void participationList(Integer memberNumber){}

    // 스터디 작성(Post)
    @PostMapping("register")
    public RedirectView register(StudyVO studyVO, RedirectAttributes rttr, HttpServletRequest req) {
        log.info("----------------------------");
        log.info("studyRegister............. : " + studyVO);
        log.info("----------------------------");

        // 이 부분은 세션에 로그인된 회원 정보가 들어오고부터 사용할 수 있음
        // HttpSession session = req.getSession();
        // Integer memberNumber = (Integer)session.getAttribute("memberNumber");
        // studyVO.setStudyMemberNumber(memberNumber);

        // 테스트용
        studyVO.setStudyMemberNumber(1);

        studyService.register(studyVO);

        rttr.addFlashAttribute("studyNumber", studyVO.getStudyNumber());

        // 원래
        // return new RedirectView("/study/read");

        // 테스트용
        return new RedirectView("/study/register");
    }

    // 스터디 수정
    @PostMapping("modify")
    public void modify(StudyVO studyVO){}

    // 스터디 삭제
    @GetMapping("remove")
    public void remove(Integer studyNumber){}

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
