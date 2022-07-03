package com.project.moyeodream.mapper;

import com.project.moyeodream.domain.vo.MemberVO;
import com.project.moyeodream.domain.vo.StudyCommentDTO;
import com.project.moyeodream.domain.vo.StudyCommentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper //스프링 마이바티스에서 xml파일과 연결될 Mapper 인터페이스임을 알려준다.
public interface StudyCommentMapper {
    // 댓글 작성
    public void insert(StudyCommentVO studyCommentVO);
    // 전체 댓글 목록
    public List<StudyCommentDTO> getList(int studyCommentStudyNumber);
    // 댓글 작성한 멤버의 정보
    public MemberVO selectMemberInfo(int studyCommentMemberNumber);
    // 댓글 수정
    public void update(StudyCommentVO studyCommentVO);
    // 댓글 삭제
    public void delete(int studyCommentNumber);
    // 댓글 총개수
    public int getTotal(int studyCommentStudyNumber);
}
