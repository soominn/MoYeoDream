package com.project.moyeodream.service;

import com.project.moyeodream.domain.dao.StudyDAO;
import com.project.moyeodream.domain.vo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("study")
public class StudyServiceImpl implements StudyService{
    private final StudyDAO studyDAO;

    @Override
    public List<StudyDTO> getList(Criteria criteria) {
        return studyDAO.getList(criteria);
    }

    @Override
    public List<StudyDTO> getListView(Criteria criteria) {
        return studyDAO.getListView(criteria);
    }

    @Override
    public List<StudyDTO> getListLatest(Criteria criteria) {
        return studyDAO.getListLatest(criteria);
    }

    @Override
    public List<StudyVO> getApproveList() {
        return studyDAO.getApproveList();
    }

    @Override
    public StudyDTO read(int studyNumber) {
        StudyDTO studyDTO = studyDAO.read(studyNumber);
        MemberVO memberVO = studyDAO.findMemberInfo(studyDTO.getStudyMemberNumber());
        studyDTO.setMemberNickname(memberVO.getMemberNickname());
        studyDTO.setMemberProfile(memberVO.getMemberProfile());
        return studyDTO;
    }

    @Override
    public StudyDTO modify(int studyNumber) {
        return studyDAO.read(studyNumber);
    };

    @Override
    public List<StudyVO> CratedList(int userNumber) {
        return studyDAO.CratedList(userNumber);
    }

    @Override
    public List<StudyVO> participatingList(int userNumber) {
        return studyDAO.participatingList(userNumber);
    }

    @Override
    public void register(StudyVO studyVO) {
        studyDAO.register(studyVO);
    }

    @Override
    public void modify(StudyVO studyVO) {
        studyDAO.update(studyVO);
    }

    @Override
    public void remove(int studyNumber) {
        studyDAO.delete(studyNumber);
    }

    @Override
    public List<StudyVO> getCategoryList(String studyCategory) {
        return studyDAO.getCategoryList(studyCategory);
    }

    @Override
    public boolean approve(int studyNumber) {
        return studyDAO.approve(studyNumber);
    }

    @Override
    public int refuse(int studyNumber) {
        return 0;
    }





    @Override
    public List<StudyVO> getApproveWait(){ return studyDAO.getApproveWait(); }

    @Override
    public List<StudyDTO> getStudyList(Criteria criteria) { return studyDAO.getStudyList(criteria); }

    @Override
    public int getTotal(Criteria criteria) {
        return studyDAO.getTotal(criteria);
    }

    @Override
    public StudyDTO adStudyRead(int studyNumber) {
        StudyDTO studyDTO = studyDAO.read(studyNumber);
        return studyDTO;
    }

    @Override
    public int getApprove(int studyNumber){return studyDAO.getApprove(studyNumber);}

    @Override
    public void check(int studyNumber){studyDAO.check(studyNumber);}
}
