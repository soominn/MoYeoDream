package com.project.moyeodream.service;

import com.project.moyeodream.domain.vo.JobpostingVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobpostingService {

    public List<JobpostingVO> getList();

    public List<JobpostingVO> getApproveList();

    public JobpostingVO jobpostRead(int jobpostingNumber);

    public void jobpostRegister(JobpostingVO jobpostingVO);

    public boolean jobpostUpdate(JobpostingVO jobpostingVO);

    public boolean jobpostRemove(int jobpostingNumber);

    public boolean approve(int jobpostingNumber);

    public boolean refuse(int jobpostingNumber);
}
