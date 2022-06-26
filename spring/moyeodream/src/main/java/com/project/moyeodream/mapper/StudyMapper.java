package com.project.moyeodream.mapper;

import com.project.moyeodream.domain.vo.StudyDTO;
import com.project.moyeodream.domain.vo.StudyVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper //스프링 마이바티스에서 xml파일과 연결될 Mapper 인터페이스임을 알려준다.
public interface StudyMapper {
    // 전체 스터디 목록
    public List<StudyVO> getList();
    // 승인된 스터디 목록
    public List<StudyVO> getApproveList();
    // 스터디 상세 조회
    public StudyDTO select(int studyNumber);
    // 스터디 만든 회원의 닉네임 찾기
    public String selectNickname(int studyMemberNumber);
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
    public int approve(int studyNumber);
    // 스터디 거절
    public int refuse(int studyNumber);
}
