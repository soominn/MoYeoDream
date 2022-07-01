package com.project.moyeodream.controller;

import com.project.moyeodream.domain.vo.*;
import com.project.moyeodream.service.InquiryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/inquiry/*")
public class InquiryController {
        private final InquiryService inquiryService;


        // 모든 문의 목록
        @GetMapping("list")
        public String list(Model model, Criteria criteria){
                log.info("----------------------------");
                log.info("list.............");
                log.info("Criteria............." + criteria);
                log.info("----------------------------");

                criteria.setAmount(10);
                PageDTO pageDTO = new PageDTO(criteria, inquiryService.getTotal());
                model.addAttribute("inquiryList", inquiryService.getTotalList(criteria));
                model.addAttribute("pageDTO", pageDTO );
                model.addAttribute("criteria", criteria);

                log.info("-------------------------------------------------");
                log.info(pageDTO.getCriteria().getListLink());
                log.info(pageDTO.toString());

                return "/inquiry/inquiryList";
        }

        //    문의 작성
        @PostMapping("register")
        public RedirectView inquiryRegister(InquiryVO inquiryVO, HttpServletRequest req){
                log.info("----------------------------");
                log.info("register............. : " + inquiryVO);
                log.info("----------------------------");

                // 세션에서 넘어온 유저 정보가 있어야 사용할 수 있음
                 HttpSession session = req.getSession();
                 Integer memberNumber = (Integer)session.getAttribute("memberNumber");
                 inquiryVO.setInquiryMemberNumber(memberNumber);

                // 유저 정보 받아오는테스트
                // inquiryVO.setInquiryMemberNumber(1);
                //-----------------------------------


                inquiryService.inquiryInsert(inquiryVO);

                return new RedirectView("/inquiry/list");
        }

        //    문의 조회
        @GetMapping("read")
        public String inquiryRead(Integer inquiryNumber, Model model, HttpServletRequest req){
                log.info("----------------------------");
                log.info("inquiryRead............. : " + inquiryNumber);
                log.info("----------------------------");

                int memberNum = 0;
                HttpSession session = req.getSession();

                if(session.getAttribute("memberNumber") != null){
                        log.info("세션 있음");
                        memberNum = (Integer)session.getAttribute("memberNumber");
                } else{
                        log.info("세션 없음");
                        memberNum = -1;
                }

                inquiryService.inquiryVisit(inquiryNumber);
                model.addAttribute("inquiry", inquiryService.getList(inquiryNumber));
                model.addAttribute("session", memberNum);
                return "/inquiry/inquiryView";
        }

        //    수정 페이지에서 문의 내용 가져오기
        @GetMapping("modifyRead")
        public String inquiryModifyRead(Integer inquiryNumber, Model model, HttpServletRequest req){
                log.info("----------------------------");
                log.info("inquiryRead............. : " + inquiryNumber);
                log.info("----------------------------");

                int memberNum = 0;
                HttpSession session = req.getSession();

                if(session.getAttribute("memberNumber") != null){
                        log.info("세션 있음");
                        memberNum = (Integer)session.getAttribute("memberNumber");
                } else{
                        log.info("세션 없음");
                        memberNum = -1;
                }

                model.addAttribute("inquiry", inquiryService.getList(inquiryNumber));
                model.addAttribute("session", memberNum);
                return "/inquiry/inquiryModify";
        }

        //    문의 수정
        @PostMapping("modify")
        public RedirectView inquiryModify(InquiryVO inquiryVO, RedirectAttributes rttr, HttpServletRequest req){
                log.info("----------------------------");
                log.info("modify............. : " + inquiryVO);
                log.info("----------------------------");

                // 세션에서 넘어온 유저 정보가 있어야 사용할 수 있음

                HttpSession session = req.getSession();
                Integer memberNumber = (Integer)session.getAttribute("memberNumber");
                inquiryVO.setInquiryMemberNumber(memberNumber);

                inquiryService.inquiryModify(inquiryVO);

                rttr.addAttribute("inquiryNumber", inquiryVO.getInquiryNumber());

                return new RedirectView("/inquiry/read");
        }

        //    문의 삭제
        @GetMapping("remove")
        public RedirectView inquiryRemove(int inquiryNumber, RedirectAttributes rttr){
                log.info("----------------------------");
                log.info("remove............. : " + inquiryNumber);
                log.info("----------------------------");

                inquiryService.inquiryDelete(inquiryNumber);
                return new RedirectView("/inquiry/list");
        }

        // ------ 프론트 ------

        // 문의 작성
        @GetMapping("inquiryCreate")
        public void inquiryCreate(){}

        // 문의 목록
        @GetMapping("inquiryList")
        public void inquiryList(){}

        // 문의 상세보기
        @GetMapping("inquiryView")
        public void inquiryView(){}

        // 답변 대기 중인 문의 글
        @GetMapping("approveWait")
        public RedirectView approveWait(Model model, RedirectAttributes rttr, HttpServletRequest req){
                Map<String, Object> flash = (Map<String, Object>) RequestContextUtils.getInputFlashMap(req);
                log.info("flash................................ : " + flash.get("jobpostingList").toString());
                rttr.addFlashAttribute("jobpostingList", flash.get("jobpostingList"));
                rttr.addFlashAttribute("number", flash.get("number"));
                rttr.addFlashAttribute("count", flash.get("count"));
                rttr.addFlashAttribute("inquiryList",inquiryService.approveWait());
                log.info("adminLogin............. Flash : " + rttr.getFlashAttributes());
                return new RedirectView("/study/approveWait");
        }

        // 문의 리스트 admin
        @GetMapping("getInqList")
        public String getInqList(Model model, Criteria criteria){
                model.addAttribute("inquiryList",inquiryService.getInqList(criteria));
                log.info("list.............................. : "+ inquiryService.getInqList(criteria));
                model.addAttribute("pageDTO", new PageDTO(criteria, inquiryService.getTotalAdmin(criteria)));
                return "/admin/adminQnaManage";

        }

        // 관리자 채용 공고 세부 조회
        @GetMapping("adInqRead")
        public String adInqRead(Integer inquiryNumber, Criteria criteria, Model model){
                log.info("----------------------------");
                log.info("inquiryListRead............. : " + inquiryNumber);
                log.info("----------------------------");
                model.addAttribute("inquiry", inquiryService.adInqRead(inquiryNumber));
                return "/admin/adminQnaView";
        }
        
        // 답변 작성
        @GetMapping("answer")
        public String answer(int inquiryNumber, Criteria criteria, String inquiryAnswer, Model model){
                InquiryDTO inquiryDTO = new InquiryDTO();
                inquiryDTO.setInquiryNumber(inquiryNumber);
                inquiryDTO.setInquiryAnswer(inquiryAnswer);
                inquiryService.answer(inquiryDTO);
                model.addAttribute("inquiry", inquiryService.adInqRead(inquiryNumber));
                return "/admin/adminQnaView";
        }
        
        // 답변 삭제
        @GetMapping("deleteAnswer")
        public String deleteAnswer(int inquiryNumber, Criteria criteria, Model model){
                inquiryService.deleteAnswer(inquiryNumber);
                model.addAttribute("inquiry", inquiryService.adInqRead(inquiryNumber));
                return "/admin/adminQnaView";
        }
}
