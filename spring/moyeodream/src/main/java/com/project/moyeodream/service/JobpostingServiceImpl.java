package com.project.moyeodream.service;

import com.project.moyeodream.domain.dao.JobpostingDAO;
import com.project.moyeodream.domain.vo.JobpostingVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("jobposting")
public class JobpostingServiceImpl implements JobpostingService{

    private JobpostingDAO jobpostingDAO;

    @Override
    public List<JobpostingVO> getList() {
        return jobpostingDAO.getList();
    }

    @Override
    public List<JobpostingVO> getApproveList() {
        return jobpostingDAO.getApproveList();
    }

    @Override
    public JobpostingVO jobpostRead(int jobpostingNumber) {
        return jobpostingDAO.jobpostRead(jobpostingNumber);
    }

    @Override
    public void jobpostRegister(JobpostingVO jobpostingVO) {
        jobpostingDAO.jobpostRegister(jobpostingVO);
    }

    @Override
    public boolean jobpostUpdate(JobpostingVO jobpostingVO) {
        return jobpostingDAO.jobpostUpdate(jobpostingVO);
    }

    @Override
    public boolean jobpostRemove(int jobpostingNumber) {
        return jobpostingDAO.jobpostRemove(jobpostingNumber);
    }

    @Override
    public boolean approve(int jobpostingNumber) {
        return jobpostingDAO.approve(jobpostingNumber);
    }

    @Override
    public boolean refuse(int jobpostingNumber) {
        return jobpostingDAO.refuse(jobpostingNumber);
    }
}
