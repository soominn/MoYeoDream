package com.project.moyeodream.domain.dao;

import com.project.moyeodream.domain.vo.StudyVO;
import com.project.moyeodream.mapper.StudyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudyDAO {
    private final StudyMapper studyMapper;

    // 전체 스터디 목록
    public List<StudyVO> getList(){
        return studyMapper.getList();
    }

    // 승인된 스터디 목록
    public List<StudyVO> getApproveList(){
        return studyMapper.getApproveList();
    }

    // 스터디 조회
    public StudyVO studyRead(int studyNumber){
        return studyMapper.read(studyNumber);
    }

    // 내가 만든 스터디 목록
    public List<StudyVO> CratedList(int userNumber){
        return studyMapper.CratedList(userNumber);
    }

    // 내가 참여중인 스터디 목록
    public List<StudyVO> participatingList(int userNumber){
        return studyMapper.participatingList(userNumber);
    }

    // 스터디 작성
    public void register(StudyVO studyVO) {
        studyMapper.insert(studyVO);
    }

    // 스터디 수정
    public boolean update(StudyVO studyVO) {
        return studyMapper.update(studyVO) == 1;
    }

    // 스터디 삭제
    public boolean delete(int studyNumber) {
        return studyMapper.delete(studyNumber) == 1;
    }

    // 카테고리 별 스터디
    public List<StudyVO> getCategoryList(String studyCategory){
        return studyMapper.getCategoryList(studyCategory);
    }

    // 스터디 승인
    public int approve(int studyNumber){
        return studyMapper.approve(studyNumber);
    }

    // 스터디 거절
    public int refuse(int studyNumber){
        return studyMapper.refuse(studyNumber);
    }
}
