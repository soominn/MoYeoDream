package com.project.moyeodream.controller;

import com.project.moyeodream.domain.vo.AdminVO;
import com.project.moyeodream.domain.vo.JobpostingVO;
import com.project.moyeodream.service.AdminService;
import com.project.moyeodream.service.JobpostingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/admin/*")
public class AdminController {
    private final AdminService adminService;
//    private final JobpostingService jobpostingService;

    // 관리자 로그인
    @PostMapping("login")
    public RedirectView adminLogin(AdminVO adminVO, RedirectAttributes rttr){
        log.info("----------------------------");
        log.info("adminLogin............. id : " + adminVO.getAdminId());
        log.info("adminLogin............. pw : " + adminVO.getAdminPw());
        log.info("adminVO............. : " + adminVO.toString());
        log.info("----------------------------");

        if(adminService.login(adminVO) != 0){
            rttr.addFlashAttribute("number",adminService.login(adminVO));
            log.info("adminLogin............. Flash : " + rttr.getFlashAttributes().get("number").toString());
            return new RedirectView("/jobPosting/approveWait");
        }
        log.info("실패");
        return new RedirectView("/admin/login");
    }
    @GetMapping("login")
    public String adminLogin(){
        return "/admin/adminLogin";
    }

//    @GetMapping("approveWait")
//    public String approveWait(Model model){
//        List<JobpostingVO> list = jobpostingService.approveWait();
//        model.addAttribute("jobposting",list);
//        return "admin/adminMain";
//    }
//    @PostMapping("id")
//    public String id(String id){
//        return adminService.id(id);
//    }

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
