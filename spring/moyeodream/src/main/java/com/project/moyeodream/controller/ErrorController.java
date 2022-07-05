package com.project.moyeodream.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/error/*")
public class ErrorController {

    // 에러 페이지 이동
    @GetMapping("error")
    public String error(){
        return "/error/error";
    }

    // 로그인이 필요할 때
    @GetMapping("loginRequiredError")
    public String loginRequiredError(){
        return "/error/loginRequiredError";
    }

}
