package com.project.moyeodream.domain.dao;

import com.project.moyeodream.domain.vo.JobpostingVO;
import com.project.moyeodream.mapper.JobpostingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JobpostingDAO {

    private JobpostingMapper jobpostingMapper;

    // 전체 채용 공고 목록
    public List<JobpostingVO> getList(){
        return jobpostingMapper.getList();
    }

    // 승인된 채용 공고 목록
    public List<JobpostingVO> getApproveList(){
        return jobpostingMapper.getApproveList();
    }

    // 채용 공고 상세 조회
    public JobpostingVO jobpostRead(int jobpostingNumber){
        return jobpostingMapper.read(jobpostingNumber);
    }

    // 채용 공고 작성
    public void jobpostRegister(JobpostingVO jobpostingVO){
        jobpostingMapper.insert(jobpostingVO);
    }

    // 채용 공고 수정
    public boolean jobpostUpdate(JobpostingVO jobpostingVO){
        return jobpostingMapper.update(jobpostingVO) == 1;
    }

    // 채용 공고 삭제
    public boolean jobpostRemove(int jobpostingNumber){
        return jobpostingMapper.delete(jobpostingNumber) == 1;
    }

    // 채용 공고 승인
    public boolean approve(int jobpostingNumber){
        return jobpostingMapper.approve(jobpostingNumber) == 1;
    }

    // 채용 공고 거절
    public boolean refuse(int jobpostingNumber){
        return jobpostingMapper.refuse(jobpostingNumber) == 1;
    }
}
