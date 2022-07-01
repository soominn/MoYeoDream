package com.project.moyeodream.domain.dao;

import com.project.moyeodream.domain.vo.Criteria;
import com.project.moyeodream.domain.vo.InquiryDTO;
import com.project.moyeodream.domain.vo.InquiryVO;
import com.project.moyeodream.mapper.InquiryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class InquiryDAO {
    private final InquiryMapper inquiryMapper;

    // 전체 문의보기
    public List<InquiryDTO> getTotalList(Criteria criteria){
        return inquiryMapper.getTotalList(criteria);
    }

    // 게시판 글 개수
    public int getTotal(){
        return inquiryMapper.getTotal();
    }

    // 문의 상세 조회
    public InquiryDTO getList(int inquiryNumber){
        return inquiryMapper.getList(inquiryNumber);
    }

    // 문의하기 작성
    public void inquiryInsert(InquiryVO inquiryVO){
        inquiryMapper.insert(inquiryVO);
    }

    // 문의하기 수정
    public boolean inquiryModify(InquiryVO inquiryVO){
        return inquiryMapper.update(inquiryVO) == 1;
    }

    // 문의하기 삭제
    public boolean inquiryDelete(int inquiryNumber){
        return inquiryMapper.delete(inquiryNumber) == 1;
    }

    // 조회수 증가
    public boolean inquiryVisit(int inquiryNumber){
        return inquiryMapper.visit(inquiryNumber) == 1;
    }

    // 문의하기 답변
    public void answer(InquiryVO inquiryVO){
        inquiryMapper.answer(inquiryVO);
    }

    // 답변되지 않은 문의하기 보기
    public List<InquiryDTO> approveWait(){
        return inquiryMapper.getApproveWait();
    };

    // 문의하기 가져오기 admin
    public List<InquiryDTO> getInqList(Criteria criteria) { return inquiryMapper.getInqList(criteria); }

    // 문의하기 전체 개수
    public int getTotalAdmin(Criteria criteria){
        return inquiryMapper.getTotalAdmin(criteria);
    }

    // 문의하기 상세 조회 관리자
    public InquiryDTO adInqRead(int inquiryNumber){
        return inquiryMapper.getList(inquiryNumber);
    }
}
