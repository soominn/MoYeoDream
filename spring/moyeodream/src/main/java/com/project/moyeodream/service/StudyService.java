package com.project.moyeodream.service;

import com.project.moyeodream.domain.vo.StudyVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudyService {

    public List<StudyVO> getList();

    public List<StudyVO> getApproveList();

    public StudyVO studyRead(int studyNumber);

    public List<StudyVO> CratedList(int userNumber);

    public List<StudyVO> participatingList(int userNumber);

    public void studyCreate(StudyVO studyVO);

    public boolean studyModify(StudyVO studyVO);

    public boolean studyDelete(int studyNumber);

    public List<StudyVO> getCategoryList(String studyCategory);

    public int approve(int studyNumber);

    public int refuse(int studyNumber);
}
