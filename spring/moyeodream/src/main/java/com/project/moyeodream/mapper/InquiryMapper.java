package com.project.moyeodream.mapper;

import com.project.moyeodream.domain.vo.InquiryVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper //스프링 마이바티스에서 xml파일과 연결될 Mapper 인터페이스임을 알려준다.
public interface InquiryMapper {
    // 전체 문의보기
    public List<InquiryVO> getTotalList();
    // 문의 상세 조회
    public InquiryVO getList(int inquiryNumber);
    // 문의하기 작성
    public void insert(InquiryVO inquiryVO);
    // 문의하기 수정
    public int update(InquiryVO inquiryVO);
    // 문의하기 삭제
    public int delete(int inquiryNumber);
    // 문의하기 답변
    public void answer(InquiryVO inquiryVO);


}
