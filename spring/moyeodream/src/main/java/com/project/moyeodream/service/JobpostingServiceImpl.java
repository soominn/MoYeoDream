package com.project.moyeodream.service;

import com.project.moyeodream.domain.dao.JobpostingDAO;
import com.project.moyeodream.domain.vo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("jobposting") @Primary
public class JobpostingServiceImpl implements JobpostingService{

    private final JobpostingDAO jobpostingDAO;

    @Override
    public List<JobpostingVO> getList() {
        return jobpostingDAO.getList();
    }

    @Override
    public List<JobpostingVO> getApproveList() {
        return jobpostingDAO.getApproveList();
    }


    @Override
    public JobpostingDTO jobpostRead(int jobpostingNumber) {
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
    public boolean jobpostVisit(int jobpostingNumber) {
        return jobpostingDAO.jobpostVisit(jobpostingNumber);
    }

    @Override
    public boolean approve(int jobpostingNumber) {
        return jobpostingDAO.approve(jobpostingNumber);
    }

    @Override
    public boolean refuse(int jobpostingNumber) {
        return jobpostingDAO.refuse(jobpostingNumber);
    }

    @Override
    public List<JobpostingVO> approveWait() { return jobpostingDAO.approveWait(); }

    @Override
    public List<JobpostingVO> getJobList(Criteria criteria) { return jobpostingDAO.getJobList(criteria); }

    @Override
    public int getTotal(Criteria criteria) {
        return jobpostingDAO.getTotal(criteria);
    }

    @Override
    public JobpostingDTO adPostRead(int jobpostingNumber) {
        JobpostingDTO jobpostingDTO = jobpostingDAO.adPostRead(jobpostingNumber);
        return jobpostingDTO;
    }

    @Override
    public int getApprove(int jobpostingNumber){return jobpostingDAO.getApprove(jobpostingNumber);}

    @Override
    public void check(int jobpostingNumber){jobpostingDAO.check(jobpostingNumber);}




}
