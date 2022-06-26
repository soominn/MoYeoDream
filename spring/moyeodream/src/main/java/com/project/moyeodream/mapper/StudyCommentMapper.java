package com.project.moyeodream.mapper;

import com.project.moyeodream.domain.vo.StudyCommentDTO;
import com.project.moyeodream.domain.vo.StudyCommentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper //스프링 마이바티스에서 xml파일과 연결될 Mapper 인터페이스임을 알려준다.
public interface StudyCommentMapper {
    // 댓글 작성
    public void insert(StudyCommentVO studyCommentVO);
    // 댓글 수정
    public int update(StudyCommentVO studyCommentVO);
    // 댓글 삭제
    public int delete(int studyCommentNumber);
    // 전체 댓글 목록
    public List<StudyCommentDTO> getList(int studyCommentStudyNumber);
    // 댓글 작성한 멤버의 닉네임
    public String selectNickname(int studyCommentMemberNumber);
}
