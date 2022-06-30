package com.project.moyeodream.controller;

import com.project.moyeodream.domain.vo.AdminVO;
import com.project.moyeodream.domain.vo.Criteria;
import com.project.moyeodream.domain.vo.StudyCommentDTO;
import com.project.moyeodream.domain.vo.StudyDTO;
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
        for (StudyDTO list: studyService.getListView(criteria)) {
            list.setStudyCommentTotal(studyCommentService.getTotal(list.getStudyNumber()));
        }
        model.addAttribute("studyList",studyService.getListView(criteria));
        model.addAttribute("jobpostingList",jobpostingService.getList(criteria));
        return "/main";
    }

    // 최신순
    @GetMapping("changeLatest")
    public String changeLatest(Model model, Criteria criteria){
        for (StudyDTO list: studyService.getListLatest(criteria)) {
            list.setStudyCommentTotal(studyCommentService.getTotal(list.getStudyNumber()));
        }
        model.addAttribute("studyList",studyService.getListLatest(criteria));
        model.addAttribute("jobpostingList",jobpostingService.getListLatest(criteria));
        return "/main";
    }
    // 인기순
    @GetMapping("changeView")
    public String changeView(Model model, Criteria criteria){
        for (StudyDTO list: studyService.getListView(criteria)) {
            list.setStudyCommentTotal(studyCommentService.getTotal(list.getStudyNumber()));
        }
        model.addAttribute("studyList",studyService.getListView(criteria));
        model.addAttribute("jobpostingList",jobpostingService.getListView(criteria));
        return "/main";
    }


}
