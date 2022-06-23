package com.project.moyeodream.service;

import com.project.moyeodream.domain.vo.StudyCommentVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface StudyCommentService {

    public void studyCommentRegister(StudyCommentVO studyCommentVO);

    public boolean studyCommentUpdate(StudyCommentVO studyCommentVO);

    public boolean studyCommentDelete(int studyCommentNumber);

    public List<StudyCommentVO> studyCommentList();
}
