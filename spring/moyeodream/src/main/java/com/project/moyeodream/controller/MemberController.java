package com.project.moyeodream.controller;

import com.project.moyeodream.domain.vo.Criteria;
import com.project.moyeodream.domain.vo.MemberVO;
import com.project.moyeodream.domain.vo.PageDTO;
import com.project.moyeodream.service.MemberService;
import com.project.moyeodream.service.PostService;
import com.project.moyeodream.service.StudyService;
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
@RequestMapping("/member/*")
public class MemberController {
    private final MemberService memberService;
    private final StudyService studyService;
    private final PostService postService;

    // 회원가입
    @ResponseBody
    @PostMapping("/join")
    public void memberJoin(@RequestBody MemberVO memberVO){
        log.info("---------------------------");
        log.info("memberJoin: " + memberVO);
        log.info("---------------------------");
        memberService.join(memberVO);
    }

    // 로그인
    @PostMapping("/login")
    public String memberLogin(String memberEmail, HttpServletRequest request){
        log.info("----------------------------");
        log.info("memberLogin............. email : " + memberEmail);
        log.info("----------------------------");

        HttpSession session = request.getSession();
        session.setAttribute("memberNumber", memberService.login(memberEmail));
        return "redirect:http://localhost:11111/member/main";
    }

    // 로그아웃
    @PostMapping("/logout")
    public String memberLogout(HttpServletRequest request){
        log.info("----------------------------");
        log.info("memberLogout");
        log.info("----------------------------");

        HttpSession session = request.getSession();
        session.removeAttribute("memberNumber");

        return "redirect:http://localhost:11111/member/main";
    }

    // 중복 이메일 체크
    @ResponseBody
    @PostMapping("/checkEmail")
    public boolean checkEmail(@RequestBody MemberVO memberVO){
        log.info("----------------------------");
        log.info("memberLogin............. email : " + memberVO.getMemberEmail());
        log.info("----------------------------");

        return memberService.checkEmail(memberVO.getMemberEmail());
    }

    // 내 정보 불러오기
    @GetMapping("read")
    public String myPageRead(Integer memberNumber, Model model){
        log.info("----------------------------");
        log.info("memberRead............. : " + memberNumber);
        log.info("----------------------------");
        model.addAttribute("member", memberService.myPageView(memberNumber));
        return "/myPage/myPage";
    }

    // 내 정보 수정(post)
    @PostMapping("modify")
    public RedirectView myProfileModify(MemberVO memberVO){
        log.info("----------------------------");
        log.info("modify............. : " + memberVO);
        log.info("----------------------------");

        memberService.memberModify(memberVO);

        return new RedirectView("/member/read?memberNumber=" + memberVO.getMemberNumber());
    }

    // 탈퇴
    @GetMapping("remove")
    public RedirectView memberRemove(Integer memberNumber, RedirectAttributes rttr){
        log.info("----------------------------");
        log.info("remove............. : " + memberNumber);
        log.info("----------------------------");

        memberService.memberDelete(memberNumber);
        return new RedirectView("/main");
    }

    // ----- 프론트 -----

    // 메인
    @GetMapping("main")
    public String main(){ return "main"; }

    // 내 정보
    @GetMapping("myPage")
    public String myPage(){ return "myPage/myPage"; }

    //내 댓글
    @GetMapping("myComment")
    public String myComment(Integer memberNumber, Model model, Criteria criteria){
        log.info("----------------------------");
        log.info("list.............");
        log.info("Criteria............." + criteria);
        log.info("memberNumber............." + memberNumber);
        log.info("getMyPostCount............." + memberService.getMyCommentCount(memberNumber));
        log.info("----------------------------");

        PageDTO pageDTO = new PageDTO(criteria, memberService.getMyCommentCount(memberNumber));
        model.addAttribute("pageDTO", pageDTO );
        model.addAttribute("myCommentList", memberService.getMyCommentList(memberNumber, criteria));
        model.addAttribute("memberNumber", memberNumber);

        log.info("-------------------------------------------------");
        log.info(pageDTO.getCriteria().getListLink());
        log.info(pageDTO.toString());

        return "myPage/myComment";
    }

    // 내 정보수정 이동
    @GetMapping("myProfile")
    public String myProfile(Integer memberNumber, Model model){
        log.info("----------------------------");
        log.info("memberRead............. : " + memberNumber);
        log.info("----------------------------");
        model.addAttribute("member", memberService.myPageView(memberNumber));
        return "/myPage/myProfile";
    }

    // 내 스터디 이동
    @GetMapping("myStudy")
    public String myStudy(Integer memberNumber, Model model){
        log.info("----------------------------");
        log.info("memberRead............. : " + memberNumber);
        log.info("----------------------------");

        model.addAttribute("memberNumber", memberNumber);
        model.addAttribute("myStudyList", memberService.getMyStudyList(memberNumber));
        model.addAttribute("selectMyStudy1", memberService.selectMyStudy1(memberNumber));
        model.addAttribute("selectMyStudy0", memberService.selectMyStudy0(memberNumber));

        return "myPage/myStudy";
    }

    // 내 스터디 상세 조회
    @GetMapping("myStudyRead")
    public String read(int studyNumber, Model model) {
        log.info("----------------------------");
        log.info("read : " + studyNumber);
        log.info("----------------------------");


        model.addAttribute("study", studyService.read(studyNumber));
        return "/myPage/myStudyDetail";
    }

    //내 게시글 이동
    @GetMapping("myPost")
    public String myPost(Integer memberNumber, Model model, Criteria criteria){
        log.info("----------------------------");
        log.info("list.............");
        log.info("Criteria............." + criteria);
        log.info("memberNumber............." + memberNumber);
        log.info("getMyPostCount............." + memberService.getMyPostCount(memberNumber));
        log.info("----------------------------");

        PageDTO pageDTO = new PageDTO(criteria, memberService.getMyPostCount(memberNumber));
        model.addAttribute("pageDTO", pageDTO );
        model.addAttribute("myPostList", memberService.getMyPostList(memberNumber, criteria));
        model.addAttribute("memberNumber", memberNumber);

        log.info("-------------------------------------------------");
        log.info(pageDTO.getCriteria().getListLink());
        log.info(pageDTO.toString());

        return "myPage/myPost";
    }

    // 내 게시글 상세 조회
    @GetMapping("myPostRead")
    public String postRead(Integer postNumber, Criteria criteria, Model model, HttpServletRequest req){
        log.info("--------------------------------------------------");
        log.info("read Controller...............");
        log.info("Criteria............." + criteria);
        log.info("--------------------------------------------------");

        int memberNum = 0;
        HttpSession session = req.getSession();

        if(session.getAttribute("memberNumber") != null){
            log.info("세션 있음");
            memberNum = (Integer)session.getAttribute("memberNumber");
        } else{
            log.info("세션 없음");
            memberNum = -1;
        }

        // 상세보기 들어오면 조회수 1 UP
        model.addAttribute("post",postService.postRead(postNumber));
        model.addAttribute("criteria",criteria);
        model.addAttribute("session", memberNum);

        return "/myPage/myPostDetail";
    }

    // 선택된 게시글 삭제
    @ResponseBody
    @PostMapping("myPostDelete")
    public List<String> deleteSubmit(@RequestBody List<String> boardIdxArray) {

        log.info("boardIdxArray={}", boardIdxArray);
        memberService.deleteBoard(boardIdxArray);
        return boardIdxArray;
    }
}
