package com.project.moyeodream.mapper;

import com.project.moyeodream.domain.vo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper //스프링 마이바티스에서 xml파일과 연결될 Mapper 인터페이스임을 알려준다.
public interface StudyMapper {
    // 전체 스터디 목록
    public List<StudyDTO> getList(Criteria criteria);
    // 전체 스터디 목록 - 인기
    public List<StudyDTO> getListView(Criteria criteria);
    // 전체 스터디 목록 - 최신
    public List<StudyDTO> getListLatest(Criteria criteria);
    // 승인된 스터디 목록
    public List<StudyVO> getApproveList();
    // 스터디 상세 조회
    public StudyDTO select(int studyNumber);
    // 스터디 만든 회원의 닉네임 찾기
    public MemberVO selectMemberInfo(int studyMemberNumber);
    // 내가 만든 스터디 목록
    public List<StudyVO> CratedList(int studyMemberNumber);
    // 내가 참여중인 스터디 목록
    public List<StudyVO> participatingList(int studyMemberNumber);
    // 스터디 작성
    public void insert(StudyVO studyVO);
    // 스터디 수정
    public int update(StudyVO studyVO);
    // 스터디 삭제
    public int delete(int studyNumber);
    // 카테고리 별 스터디
    public List<StudyVO> getCategoryList(String studyCategory);
    // 스터디 승인
    public boolean approve(int studyNumber);
    // 스터디 거절
    public int refuse(int studyNumber);
    
    
    // 승인 대기 10개 게시물
    public List<StudyVO> getApproveWait();
    // 스터디 가져오기 admin
    public List<StudyDTO> getStudyList(Criteria criteria);
    // 스터디 전체 개수
    public int getTotal(Criteria criteria);
    // 승인 여부 확인
    public int getApprove(int studyNumber);
    // 체크한 스터디
    public void check(int studyNumber);
}
