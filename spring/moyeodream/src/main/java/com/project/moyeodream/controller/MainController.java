package com.project.moyeodream.controller;

import com.project.moyeodream.domain.vo.*;
import com.project.moyeodream.service.AdminService;
import com.project.moyeodream.service.JobpostingService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/main/*")
public class MainController {
    private final StudyService studyService;
    private final StudyCommentService studyCommentService;
    private final JobpostingService jobpostingService;

    // 메인페이지
    @GetMapping("index")
    public String index(Model model, Criteria criteria){
        // 인기순
        List<StudyDTO> studyList = studyService.getListView(criteria);

        for (StudyDTO list: studyList) {
            list.setStudyCommentTotal(studyCommentService.getTotal(list.getStudyNumber()));
            log.info("getTotal comment___________ : "+list.getStudyCommentTotal());
        }
        model.addAttribute("studyList",studyList);
        model.addAttribute("jobpostingList",jobpostingService.getList(criteria));
        model.addAttribute("check", 0);
        return "/main";
    }

    // 최신순
    @GetMapping("changeLatest")
    public String changeLatest(Model model, Criteria criteria){
        List<StudyDTO> studyList = studyService.getListLatest(criteria);

        for (StudyDTO list: studyList) {
            list.setStudyCommentTotal(studyCommentService.getTotal(list.getStudyNumber()));
            log.info("getTotal comment___________ : "+list.getStudyCommentTotal());
        }
        model.addAttribute("studyList",studyList);
        model.addAttribute("jobpostingList",jobpostingService.getListLatest(criteria));
        model.addAttribute("check", 1);
        return "/main";
    }
    // 인기순
    @GetMapping("changeView")
    public String changeView(Model model, Criteria criteria){
        List<StudyDTO> studyList = studyService.getListView(criteria);

        for (StudyDTO list: studyList) {
            list.setStudyCommentTotal(studyCommentService.getTotal(list.getStudyNumber()));
            log.info("getTotal comment___________ : "+list.getStudyCommentTotal());
        }
        model.addAttribute("studyList",studyList);
        model.addAttribute("jobpostingList",jobpostingService.getListView(criteria));
        model.addAttribute("check", 0);
        return "/main";
    }
    
    // 카테고리 검색 - 인기순
    @GetMapping("categoryView")
    @ResponseBody
    public List<StudyDTO> categoryView(Criteria criteria, Model model){
        log.info("==============================================================================================================================");
        log.info("겟카테고리" + criteria.getCategory());
        List<StudyDTO> studyList = studyService.getListView(criteria);
        for (StudyDTO list: studyList) {
            list.setStudyCommentTotal(studyCommentService.getTotal(list.getStudyNumber()));
        }

        return studyList;
    }
    // 카테고리 검색 - 최신순
    @GetMapping("categoryLatest")
    @ResponseBody
    public List<StudyDTO> categoryLatest(Criteria criteria, Model model){
        log.info("==============================================================================================================================");
        log.info("겟카테고리" + criteria.getCategory());
        List<StudyDTO> studyList = studyService.getListView(criteria);
        for (StudyDTO list: studyList) {
            list.setStudyCommentTotal(studyCommentService.getTotal(list.getStudyNumber()));
        }
        return studyList;
    }
    
    // 채용공고
    @GetMapping("jobList")
    @ResponseBody
    public List<JobpostingDTO> jobList(Criteria criteria){
        List<JobpostingDTO> jobpostingList = jobpostingService.getListView(criteria);
        log.info("==============================================================================================================================");
        log.info("- 가져온 채용공고 : " + jobpostingList);
        return jobpostingList;
    }
    // 채용공고 최신
    @GetMapping("jobListLatest")
    @ResponseBody
    public List<JobpostingDTO> jobListLatest(Criteria criteria){
        List<JobpostingDTO> jobpostingList = jobpostingService.getListLatest(criteria);
        return jobpostingList;
    }

    // 스크롤
    @GetMapping("scroll")
    @ResponseBody
    public List<JobpostingDTO> scroll(Criteria criteria){
        List<JobpostingDTO> jobpostingList = jobpostingService.getListLatest(criteria);
        return jobpostingList;
    }

}
