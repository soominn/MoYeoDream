package com.project.moyeodream.controller;

import com.project.moyeodream.domain.vo.StudyCommentDTO;
import com.project.moyeodream.domain.vo.StudyCommentVO;
import com.project.moyeodream.service.StudyCommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/studyComment/*")
@RequiredArgsConstructor
public class StudyCommentController {
    private final StudyCommentService studyCommentService;

    // 전체 댓글 목록 조회
    @GetMapping("/list/{studyCommentStudyNumber}")
    public List<StudyCommentDTO> getList(@PathVariable("studyCommentStudyNumber") int studyCommentStudyNumber) {
        log.info("getList........... : " + studyCommentStudyNumber);
        return studyCommentService.getList(studyCommentStudyNumber);
    }

    // 댓글 작성
    @PostMapping("/register")
    public void studyCommentWrite(@RequestBody StudyCommentVO studyCommentVO) {
        log.info("studyCommentVO : " + studyCommentVO);
        studyCommentService.register(studyCommentVO);
    }

    // 댓글 수정
    @PostMapping("/modify")
    public void studyCommentUpdate(@RequestBody StudyCommentVO studyCommentVO) {
        log.info("studyCommentVO : " + studyCommentVO);
        studyCommentService.modify(studyCommentVO);
    }

    // 댓글 삭제
    @GetMapping("/remove/{studyCommentNumber}")
    public void studyCommentRemove(@PathVariable("studyCommentNumber") int studyCommentNumber) {
        log.info("studyCommentNumber : " + studyCommentNumber);
        studyCommentService.remove(studyCommentNumber);
    }

    // 내 댓글 목록 조회
    @GetMapping("myList")
    public void myStudyComment(Integer studyCommentMemberNumber) { }
}
