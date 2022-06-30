package com.project.moyeodream.mapper;

import com.project.moyeodream.domain.vo.Criteria;
import com.project.moyeodream.domain.vo.MemberVO;
import com.project.moyeodream.domain.vo.PostDTO;
import com.project.moyeodream.domain.vo.StudyDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper //스프링 마이바티스에서 xml파일과 연결될 Mapper 인터페이스임을 알려준다.
public interface MemberMapper {
    // 회원 가입
    public void insert(MemberVO memberVO);
    // 로그인
    public int login(String memberEmail);
    // 중복된 이메일 검사
    public int checkEmail(String memberEmail);
    // 내 정보 보기
    public MemberVO select(int memberNumber);
    // 내 정보 수정
    public int update(MemberVO memberVO);
    // 회원 탈퇴
    public int delete(int memberNumber);

    // 전체 문의보기
    public List<StudyDTO> getMyStudyList(int memberNumber);

    // 내 승인된 스터디 개수
    public int selectMyStudy1(int memberNumber);

    // 내 대기 중인 스터디 개수
    public int selectMyStudy0(int memberNumber);

    // 내 게시물 목록
    public List<PostDTO> getMyPostList(@Param("memberNumber") int memberNumber, @Param("criteria") Criteria criteria);

    // 내 게시글 개수
    public int getMyPostCount(int memberNumber);

    // 선택된 게시글 삭제
    public int deleteBoard(String boardIdx);

    // 내 댓글 목록
    public List<PostDTO> getMyCommentList(@Param("memberNumber") int memberNumber, @Param("criteria") Criteria criteria);

    // 내 댓글 개수
    public int getMyCommentCount(int memberNumber);
}
