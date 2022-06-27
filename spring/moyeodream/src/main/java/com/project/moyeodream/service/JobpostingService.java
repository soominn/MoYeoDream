package com.project.moyeodream.service;

import com.project.moyeodream.domain.vo.Criteria;
import com.project.moyeodream.domain.vo.JobpostingDTO;
import com.project.moyeodream.domain.vo.JobpostingVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobpostingService {

    public List<JobpostingVO> getList();

    public List<JobpostingVO> getApproveList();

    public JobpostingDTO jobpostRead(int jobpostingNumber, int jobpostingMemberNumber);

    public void jobpostRegister(JobpostingVO jobpostingVO);

    public boolean jobpostUpdate(JobpostingVO jobpostingVO);

    public boolean jobpostRemove(int jobpostingNumber);

    public boolean jobpostVisit(int jobpostingNumber);

    public boolean approve(int jobpostingNumber);

    public boolean refuse(int jobpostingNumber);

    public List<JobpostingVO> approveWait();

    public List<JobpostingVO> getJobList(Criteria criteria);

    public int getTotal(Criteria criteria);

    public JobpostingDTO adPostRead(int jobpostingNumber);
}
