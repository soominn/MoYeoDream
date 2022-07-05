package com.project.moyeodream.controller;

import com.project.moyeodream.domain.vo.*;
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

        return "redirect:http://localhost:11111/main/index";
    }

    // 로그아웃
    @PostMapping("/logout")
    public String memberLogout(HttpServletRequest request){
        log.info("----------------------------");
        log.info("memberLogout");
        log.info("----------------------------");

        HttpSession session = request.getSession();
        session.removeAttribute("memberNumber");

        return "redirect:http://localhost:11111/main/index";
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

    // 프로필 가져오기
    @ResponseBody
    @PostMapping("/checkProfile")
    public String checkProfile(@RequestBody MemberVO memberVO){
        log.info("----------------------------");
        log.info("checkProfile............. memberNumber : " + memberVO.getMemberNumber());
        log.info("----------------------------");

        return memberService.checkProfile(memberVO.getMemberNumber());
    }

    // 내 정보 불러오기
    @GetMapping("read")
    public String myPageRead(Model model, HttpServletRequest req){
        HttpSession session = req.getSession();
        Integer memberNumber = (Integer)session.getAttribute("memberNumber");

        String root = "";
        if(memberNumber == null){
            root += "/error/loginRequiredError";
        }else{
            log.info("----------------------------");
            log.info("memberRead............. : " + memberNumber);
            log.info("----------------------------");

            model.addAttribute("member", memberService.myPageView(memberNumber));
            model.addAttribute("session", memberNumber);

            root += "/myPage/myPage";
        }
        return root;
    }

    // 내 정보 수정(post)
    @PostMapping("modify")
    public RedirectView myProfileModify(MemberVO memberVO){
        log.info("----------------------------");
        log.info("modify............. : " + memberVO);
        log.info("----------------------------");

        memberService.memberModify(memberVO);

        return new RedirectView("/member/read");
    }

    // 탈퇴
    @GetMapping("remove")
    public RedirectView memberRemove(Integer memberNumber){
        log.info("----------------------------");
        log.info("remove............. : " + memberNumber);
        log.info("----------------------------");

        memberService.memberDelete(memberNumber);
        return new RedirectView("/main/index");
    }

    // ----- 프론트 -----

    // 메인
    @GetMapping("main")
    public String main(){ return "main"; }

    // 내 정보
    @GetMapping("myPage")
    public String myPage(){ return "myPage/myPage"; }



    // 내 정보수정 이동
    @GetMapping("myProfile")
    public String myProfile(Model model, HttpServletRequest req){
        HttpSession session = req.getSession();
        Integer memberNumber = (Integer)session.getAttribute("memberNumber");

        log.info("----------------------------");
        log.info("memberRead............. : " + memberNumber);
        log.info("----------------------------");
        model.addAttribute("member", memberService.myPageView(memberNumber));
        return "/myPage/myProfile";
    }

    // 내 스터디 이동
    @GetMapping("myStudy")
    public String myStudy(Model model, HttpServletRequest req){
        HttpSession session = req.getSession();
        Integer memberNumber = (Integer)session.getAttribute("memberNumber");

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
    public String read(int studyNumber, Model model, HttpServletRequest req) {
        log.info("----------------------------");
        log.info("read : " + studyNumber);
        log.info("----------------------------");

        HttpSession session = req.getSession();
        Integer memberNumber = (Integer)session.getAttribute("memberNumber");

        studyService.views(studyNumber);
        model.addAttribute("study", studyService.read(studyNumber));
        model.addAttribute("session", memberNumber);

        return "/myPage/myStudyDetail";
    }

    // 내 스터디 수정 이동
    @GetMapping("myStudyModifyRead")
    public String modify(Integer studyNumber, Model model) {
        log.info("----------------------------");
        log.info("modify : " + studyNumber);
        log.info("----------------------------");
        model.addAttribute("study", studyService.modify(studyNumber));
        return "myPage/myStudyModify";
    }

    // 내 스터디 수정 완료
    @PostMapping("myStudyModify")
    public RedirectView modify(StudyVO studyVO, HttpServletRequest req) {
        log.info("----------------------------");
        log.info("modify : " + studyVO);
        log.info("----------------------------");

        HttpSession session = req.getSession();
        Integer memberNumber = (Integer)session.getAttribute("memberNumber");
        studyVO.setStudyMemberNumber(memberNumber);

        studyService.modify(studyVO);

        return new RedirectView("/member/myStudyRead?studyNumber=" + studyVO.getStudyNumber());
    }

    //내 게시글 이동
    @GetMapping("myPost")
    public String myPost(Model model, Criteria criteria, HttpServletRequest req){
        HttpSession session = req.getSession();
        Integer memberNumber = (Integer)session.getAttribute("memberNumber");

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

        HttpSession session = req.getSession();
        Integer memberNumber = (Integer)session.getAttribute("memberNumber");

        // 상세보기 들어오면 조회수 1 UP
        model.addAttribute("post",postService.postRead(postNumber));
        model.addAttribute("criteria",criteria);
        model.addAttribute("session", memberNumber);

        return "/myPage/myPostDetail";
    }

    // 내 게시글 수정 이동
    @GetMapping("myPostModifyRead")
    public String goModify(Criteria criteria, Integer postNumber, Model model){
        log.info("-----------------------------------------------");
        log.info("go Modify Controller........................");
        log.info("criteria ........" + criteria);
        log.info("-----------------------------------------------");

        model.addAttribute("post",postService.postRead(postNumber));
        model.addAttribute("criteria",criteria);

        return "/myPage/myPostModify";
    }

    // 내 게시글 수정 완료
    @PostMapping("myPostModify")
    public RedirectView postModify(PostVO postVO, Criteria criteria, RedirectAttributes rttr, HttpServletRequest req){
        log.info("---------------------------------------------------");
        log.info("modifyOk controller..................");
        log.info("criteria..........................."+ criteria);
        log.info("---------------------------------------------------");

        log.info(" 받아온 컨텐츠 내용 : " + postVO.getPostContent());
        postService.postUpdate(postVO);

        HttpSession session = req.getSession();
        Integer memberNumber = (Integer)session.getAttribute("memberNumber");

        rttr.addAttribute("session", memberNumber);
        rttr.addAttribute("postNumber", postVO.getPostNumber());
        rttr.addFlashAttribute("criteria", criteria);

        return new RedirectView("/member/myPostRead");
    }

    // 선택된 게시글 삭제
    @ResponseBody
    @PostMapping("myPostDelete")
    public List<String> deleteSubmit(@RequestBody List<String> boardIdxArray) {

        log.info("boardIdxArray={}", boardIdxArray);
        memberService.deleteBoard(boardIdxArray);
        return boardIdxArray;
    }

    //내 댓글 이동
    @GetMapping("myComment")
    public String myComment(Model model, Criteria criteria, HttpServletRequest req){
        HttpSession session = req.getSession();
        Integer memberNumber = (Integer)session.getAttribute("memberNumber");

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

    // 내 댓글 상세 조회
    @GetMapping("myCommentRead")
    public String commentRead(Integer postNumber, Criteria criteria, Model model, HttpServletRequest req){
        log.info("--------------------------------------------------");
        log.info("read Controller...............");
        log.info("Criteria............." + criteria);
        log.info("--------------------------------------------------");

        HttpSession session = req.getSession();
        Integer memberNumber = (Integer)session.getAttribute("memberNumber");

        // 상세보기 들어오면 조회수 1 UP
        model.addAttribute("post",postService.postRead(postNumber));
        model.addAttribute("criteria",criteria);
        model.addAttribute("session", memberNumber);

        return "/myPage/myCommentDetail";
    }
}
