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

    // 댓글 작성
    @PostMapping("register")
    public void studyCommentWrite(StudyCommentVO studyCommentVO) { }

    // 댓글 수정
    @PostMapping("modify")
    public void studyCommentUpdate(StudyCommentVO studyCommentVO) { }

    // 댓글 삭제
    @GetMapping("remove")
    public void studyCommentRemove(Integer studyCommentNumber) { }

    // 전체 댓글 목록 조회
    @GetMapping("/list/{studyCommentStudyNumber}")
    public List<StudyCommentDTO> getList(@PathVariable("studyCommentStudyNumber") int studyCommentStudyNumber) {
        log.info("getList........... : " + studyCommentStudyNumber);
        return studyCommentService.getList(studyCommentStudyNumber);
    }

    // 내 댓글 목록 조회
    @GetMapping("myList")
    public void myStudyComment(Integer studyCommentMemberNumber) { }
}
