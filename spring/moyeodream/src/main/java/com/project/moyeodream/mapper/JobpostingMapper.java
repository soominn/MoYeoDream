package com.project.moyeodream.mapper;

import com.project.moyeodream.domain.vo.Criteria;
import com.project.moyeodream.domain.vo.JobpostingDTO;
import com.project.moyeodream.domain.vo.JobpostingVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper //스프링 마이바티스에서 xml파일과 연결될 Mapper 인터페이스임을 알려준다.
public interface JobpostingMapper {
    // 전체 채용 공고 목록
    public List<JobpostingDTO> getList(Criteria criteria);
    // 전체 채용 공고 목록 - 인기
    public List<JobpostingDTO> getListView(Criteria criteria);
    // 전체 채용 공고 목록 - 최신
    public List<JobpostingDTO> getListLatest(Criteria criteria);
    // 승인된 채용 공고 목록
    public List<JobpostingVO> getApproveList();
    // 채용 공고 상세 조회
    public JobpostingDTO read(int jobpostingNumber);
    // 채용 공고 작성
    public void insert(JobpostingVO jobpostingVO);
    // 채용 공고 수정
    public int update(JobpostingVO jobpostingVO);
    // 채용 공고 삭제
    public int delete(int jobpostingNumber);
    // 조회수 수정
    public int visit(int jobpostingNumber);
    // 채용 공고 승인
    public boolean approve(int jobpostingNumber);
    // 채용 공고 거절
    public int refuse(int jobpostingNumber);
    // 승인 대기 채용 공고
    public List<JobpostingVO> getApproveWait();
    // 채용 공고 가져오기 admin
    public List<JobpostingVO> getJobList(Criteria criteria);
    // 채용 공고 전체 개수
    public int getTotal(Criteria criteria);
    // 승인 여부 확인
    public int getApprove(int jobpostingNumber);
    // 체크한 공고
    public void check(int jobpostingNumber);
}
