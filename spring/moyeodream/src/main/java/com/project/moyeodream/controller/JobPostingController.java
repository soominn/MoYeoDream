package com.project.moyeodream.controller;

import com.project.moyeodream.domain.vo.Criteria;
import com.project.moyeodream.domain.vo.JobpostingVO;
import com.project.moyeodream.domain.vo.PageDTO;
import com.project.moyeodream.service.JobpostingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/jobPosting/*")
public class JobPostingController {
    private final JobpostingService jobpostingService;

    //    모든 채용 공고 목록
    @GetMapping("list")
    public void jobPostList(){}

    //    승인된 채용 공고 목록
    @GetMapping("approveList")
    public void jobPostApprove(){}


    //    채용 공고 조회
    @GetMapping("read")
    public String jobPostRead(Integer jobpostingNumber, Integer jobpostingMemberNumber, Model model){
        log.info("----------------------------");
        log.info("jobpostingRead............. : " + jobpostingNumber);
        log.info("jobpostingMemberRead............. : " + jobpostingMemberNumber);
        log.info("----------------------------");
        jobpostingService.jobpostVisit(jobpostingNumber);
        model.addAttribute("jobPosting", jobpostingService.jobpostRead(jobpostingNumber, jobpostingMemberNumber));
        return "/jobPosting/jobPostingView";
    }


    //    수정 페이지에서 공고 내용 가져오기
    @GetMapping("modifyRead")
    public String inquiryModifyRead(Integer jobpostingNumber, Integer jobpostingMemberNumber, Model model){
        log.info("----------------------------");
        log.info("jobpostingRead............. : " + jobpostingNumber);
        log.info("jobpostingMemberRead............. : " + jobpostingMemberNumber);
        log.info("----------------------------");
        model.addAttribute("jobPosting", jobpostingService.jobpostRead(jobpostingNumber, jobpostingMemberNumber));
        return "/jobPosting/jobPostingModify";
    }

    //    채용 공고 작성
    @PostMapping("register")
    public RedirectView jobPostRegister(JobpostingVO jobpostingVO, RedirectAttributes rttr){
        log.info("----------------------------");
        log.info("register............. : " + jobpostingVO);
        log.info("----------------------------");

        // 세션에서 넘어온 유저 정보가 있어야 사용할 수 있음
        // HttpSession session = req.getSession();
        // Integer memberNumber = (Integer)session.getAttribute("memberNumber");
        // jobpostingVO.setJobpostingMemberNumber(memberNumber);

        // 유저 정보 받아오는테스트
        jobpostingVO.setJobpostingMemberNumber(1);
        //-----------------------------------

        jobpostingService.jobpostRegister(jobpostingVO);
        rttr.addFlashAttribute("jobpostingNumber", jobpostingVO.getJobpostingNumber());

        return new RedirectView("/main");
    }

    //    채용 공고 수정
    @PostMapping("modify")
    public RedirectView jobPostModify(JobpostingVO jobpostingVO, RedirectAttributes rttr){
        log.info("----------------------------");
        log.info("modify............. : " + jobpostingVO);
        log.info("----------------------------");

        // 세션에서 넘어온 유저 정보가 있어야 사용할 수 있음
        // HttpSession session = req.getSession();
        // Integer memberNumber = (Integer)session.getAttribute("memberNumber");
        // jobpostingVO.setJobpostingMemberNumber(memberNumber);

        // 유저 정보 받아오는테스트
        jobpostingVO.setJobpostingMemberNumber(1);
        //-----------------------------------

        jobpostingService.jobpostUpdate(jobpostingVO);

        rttr.addAttribute("jobpostingNumber", jobpostingVO.getJobpostingNumber());
        rttr.addAttribute("jobpostingMemberNumber", jobpostingVO.getJobpostingMemberNumber());

        return new RedirectView("/jobPosting/read");
    }

    //    채용 공고 삭제
    @GetMapping("remove")
    public RedirectView jobPostRemove(int jobpostingNumber, RedirectAttributes rttr){
        log.info("----------------------------");
        log.info("remove............. : " + jobpostingNumber);
        log.info("----------------------------");

        jobpostingService.jobpostRemove(jobpostingNumber);
        return new RedirectView("/main");
    }

    // 채용 공고 승인
    @PostMapping("approve")
    public RedirectView jobPostApprove(Integer jobpostingNumber, Criteria criteria, RedirectAttributes rttr){

        log.info("가져온 번호.................... : " + jobpostingNumber);
        boolean app = jobpostingService.approve(jobpostingNumber);
        log.info("수정 여부.................... : " + app);
        
        rttr.addAttribute(jobpostingNumber);
        rttr.addFlashAttribute(criteria);
        return new RedirectView("/jobPosting/getJobList");
    }

    //    채용 공고 거절
    @GetMapping("refuse")
    public void jobPostRefuse(Integer jobPostingNumber){}

    // ----- 프론트 -----

    // 채용 공고 작성
    @GetMapping("jobPostingCreate")
    public void jobPostingCreate() {}

    // 채용 공고 상세 보기
    @GetMapping("jobPostingView")
    public void jobPostingView() {}

    // 승인대기 채용공고
    @GetMapping("approveWait")
    public RedirectView approveWait(RedirectAttributes rttr){
        List<JobpostingVO> list = jobpostingService.approveWait();
        rttr.addFlashAttribute("jobpostingList", list);
        rttr.addFlashAttribute("number", rttr.getFlashAttributes());
        log.info("adminLogin............. Flash : " + rttr.getFlashAttributes());
        return new RedirectView("/inquiry/approveWait");
    }

    // 채용공고 리스트 admin
    @GetMapping("getJobList")
    public String getJobList(Model model, Criteria criteria){
        model.addAttribute("jobpostingList",jobpostingService.getJobList(criteria));
        model.addAttribute("pageDTO", new PageDTO(criteria, jobpostingService.getTotal(criteria)));
        return "admin/adminPostManage";
    }

    // 관리자 채용 공고 세부 조회
    @GetMapping("adPostRead")
    public String adPostRead(Integer jobpostingNumber, Model model){
        log.info("----------------------------");
        log.info("jobpostingRead............. : " + jobpostingNumber);
        log.info("----------------------------");
        model.addAttribute("jobPosting", jobpostingService.adPostRead(jobpostingNumber));
        return "admin/adminPostView";
    }
}
