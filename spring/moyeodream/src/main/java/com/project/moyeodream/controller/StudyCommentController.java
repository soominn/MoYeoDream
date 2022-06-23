package com.project.moyeodream.controller;

import com.project.moyeodream.domain.vo.StudyCommentVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/comment/*")
public class StudyCommentController {
    // 댓글 작성
    @PostMapping("register")
    public void studyCommentWrite(StudyCommentVO studyCommentVO){ }

    // 댓글 수정
    @PostMapping("modify")
    public void studyCommentUpdate(StudyCommentVO studyCommentVO){ }

    // 댓글 삭제
    @GetMapping("remove")
    public void studyCommentRemove(Integer studyCommentNumber){ }

    // 전체 댓글 목록 조회
    @GetMapping("list")
    public void studyComment(Integer studyCommentStudyNumber){ }

    // 내 댓글 목록 조회
    @GetMapping("myList")
    public void myStudyComment(Integer studyCommentMemberNumber){ }
}
