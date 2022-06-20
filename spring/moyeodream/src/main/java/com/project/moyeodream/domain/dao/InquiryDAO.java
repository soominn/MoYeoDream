package com.project.moyeodream.domain.dao;

import com.project.moyeodream.domain.vo.InquiryVO;
import com.project.moyeodream.mapper.InquiryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class InquiryDAO {
    private InquiryMapper inquiryMapper;

    // 전체 문의보기
    public List<InquiryVO> getTotalList(){
        return inquiryMapper.getTotalList();
    }

    // 문의 상세 조회
    public InquiryVO getList(int inquiryNumber){
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

    // 문의하기 답변
    public void answer(InquiryVO inquiryVO){
        inquiryMapper.answer(inquiryVO);
    }
}
