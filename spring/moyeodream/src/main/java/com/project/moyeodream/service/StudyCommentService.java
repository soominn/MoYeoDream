package com.project.moyeodream.service;

import com.project.moyeodream.domain.dao.StudyCommentDAO;
import com.project.moyeodream.domain.vo.MemberVO;
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
        studyCommentDAO.register(studyCommentVO);
    }

    public void modify(StudyCommentVO studyCommentVO) {
        studyCommentDAO.modify(studyCommentVO);
    }

    public void remove(int studyCommentNumber) {
        studyCommentDAO.remove(studyCommentNumber);
    }

    public List<StudyCommentDTO> getList(int studyCommentStudyNumber) {
        List<StudyCommentDTO> studyCommentDTOS = studyCommentDAO.getList(studyCommentStudyNumber);
        studyCommentDTOS.forEach(DTO -> {
            MemberVO memberVO = studyCommentDAO.selectNickname(DTO.getStudyCommentMemberNumber());
            DTO.setMemberNickname(memberVO.getMemberNickname());
            DTO.setMemberProfile(memberVO.getMemberProfile());
            DTO.setCommentTotal(studyCommentDAO.getTotal(studyCommentStudyNumber));
        });
        return studyCommentDTOS;
    }

    public Integer getTotal(int studyCommentStudyNumber){
        return studyCommentDAO.getTotal(studyCommentStudyNumber);
    }
}
