package com.project.moyeodream.service;

import com.project.moyeodream.domain.dao.StudyCommentDAO;
import com.project.moyeodream.domain.vo.StudyCommentVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("comment")
public class StudyCommentServiceImpl implements StudyCommentService {

    private StudyCommentDAO studyCommentDAO;

    @Override
    public void studyCommentRegister(StudyCommentVO studyCommentVO) {
        studyCommentDAO.studyCommentRegister(studyCommentVO);
    }

    @Override
    public boolean studyCommentUpdate(StudyCommentVO studyCommentVO) {
        return studyCommentDAO.studyCommentUpdate(studyCommentVO);
    }

    @Override
    public boolean studyCommentDelete(int studyCommentNumber) {
        return studyCommentDAO.studyCommentDelete(studyCommentNumber);
    }

    @Override
    public List<StudyCommentVO> studyCommentList() {
        return studyCommentDAO.studyCommentList();
    }
}
