package com.project.moyeodream.service;

import com.project.moyeodream.domain.dao.StudyCommentDAO;
import com.project.moyeodream.domain.vo.StudyCommentDTO;
import com.project.moyeodream.domain.vo.StudyCommentVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudyCommentService {
    private final StudyCommentDAO studyCommentDAO;

    public void register(StudyCommentVO studyCommentVO) {

    }

    public void update(StudyCommentVO studyCommentVO) {

    }

    public void delete(int studyCommentNumber) {

    }

    public List<StudyCommentDTO> getList(int studyCommentStudyNumber) {
        List<StudyCommentDTO> studyCommentDTOS = studyCommentDAO.getList(studyCommentStudyNumber);
        studyCommentDTOS.forEach(DTO -> DTO.setMemberNickname(studyCommentDAO.selectNickname(DTO.getStudyCommentMemberNumber())));
        return studyCommentDTOS;
    }
}
