package com.project.moyeodream.controller;

import com.project.moyeodream.domain.vo.AdminVO;
import com.project.moyeodream.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/admin/*")
public class AdminController {
    private final AdminService adminService;
    // 관리자 로그인
    @PostMapping("login")
    public String adminLogin(AdminVO adminVO, Model model){
        log.info("----------------------------");
        log.info("adminLogin............. id : " + adminVO.getAdminId());
        log.info("adminLogin............. pw : " + adminVO.getAdminPw());
        log.info("adminVO............. : " + adminVO.toString());
        log.info("----------------------------");

        if(adminService.login(adminVO) != 0){
            model.addAttribute("number",adminService.login(adminVO));
            log.info("adminLogin............. Flash : " + model.getAttribute("number"));
            return "/admin/adminMain";
        }
        log.info("실패");
        return "/admin/adminLogin";
    }
    @GetMapping("login")
    public String adminLogin(){
        return "/admin/adminLogin";
    }
    @PostMapping("id")
    public String id(String id){
        return adminService.id(id);
    }

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
