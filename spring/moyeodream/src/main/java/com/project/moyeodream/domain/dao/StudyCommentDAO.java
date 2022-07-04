package com.project.moyeodream.domain.dao;

import com.project.moyeodream.domain.vo.MemberVO;
import com.project.moyeodream.domain.vo.StudyCommentDTO;
import com.project.moyeodream.domain.vo.StudyCommentVO;
import com.project.moyeodream.mapper.StudyCommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudyCommentDAO {
    private final StudyCommentMapper studyCommentMapper;

    // 댓글 작성
    public void register(StudyCommentVO studyCommentVO) {
        studyCommentMapper.insert(studyCommentVO);
    }

    // 전체 댓글 목록
    public List<StudyCommentDTO> getList(int studyCommentStudyNumber) {
        return studyCommentMapper.getList(studyCommentStudyNumber);
    }

    // 댓글 작성한 멤버의 닉네임
    public MemberVO selectNickname(int studyCommentMemberNumber) {
        return studyCommentMapper.selectMemberInfo(studyCommentMemberNumber);
    }

    // 댓글 수정
    public void modify(StudyCommentVO studyCommentVO) {
        studyCommentMapper.update(studyCommentVO);
    }

    // 댓글 삭제
    public void remove(int studyCommentNumber) {
        studyCommentMapper.delete(studyCommentNumber);
    }

    // 댓글 총개수
    public int getTotal(int studyCommentStudyNumber) {
        return studyCommentMapper.getTotal(studyCommentStudyNumber);
    };
}
