package com.project.moyeodream.controller;

import com.project.moyeodream.domain.vo.InquiryVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/inquiry/*")
public class InquiryController {

        // 모든 문의 목록
        @GetMapping("list")
        public void list(){}

        //    문의 조회
        @GetMapping("read")
        public void inquiryRead(Integer inquiryNumber){}

        //    문의 작성
        @PostMapping("register")
        public void inquiryRegister(InquiryVO inquiryVO){}

        //    문의 수정
        @PostMapping("modify")
        public void inquiryModify(InquiryVO inquiryVO){}

        //    문의 삭제
        @GetMapping("remove")
        public void inquiryRemove(Integer inquiryNumber){}

        // ------ 프론트 ------

        // 문의 작성
        @GetMapping("inquiryCreate")
        public void inquiryCreate(){}

        @GetMapping("inquiryList")
        public void inquiryList(){}

        @GetMapping("inquiryView")
        public void inquiryView(){}
}
