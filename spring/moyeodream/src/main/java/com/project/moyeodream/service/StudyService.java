package com.project.moyeodream.service;

import com.project.moyeodream.domain.vo.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudyService {
    public List<StudyDTO> getList(Criteria criteria);
    public List<StudyDTO> getListView(Criteria criteria);
    public List<StudyDTO> getListLatest (Criteria criteria);
    public List<StudyVO> getApproveList();
    public StudyDTO read(int studyNumber);
    public List<StudyVO> CratedList(int userNumber);
    public List<StudyVO> participatingList(int userNumber);
    public void register(StudyVO studyVO);
    public StudyDTO modify(int studyNumber);
    public void modify(StudyVO studyVO);
    public void remove(int studyNumber);
    public void views(int studyNumber);
    public List<StudyVO> getCategoryList(String studyCategory);
    public boolean approve(int studyNumber);
    public int refuse(int studyNumber);
    public List<StudyVO> getApproveWait();
    public List<StudyDTO> getStudyList(Criteria criteria);
    public int getTotal(Criteria criteria);
    public int getTotalC(Criteria criteria);
    public StudyDTO adStudyRead(int studyNumber);
    public int getApprove(int studyNumber);
    public void check(int studyNumber);
}
