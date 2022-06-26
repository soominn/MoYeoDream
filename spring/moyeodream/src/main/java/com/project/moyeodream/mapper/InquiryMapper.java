package com.project.moyeodream.mapper;

import com.project.moyeodream.domain.vo.Criteria;
import com.project.moyeodream.domain.vo.InquiryDTO;
import com.project.moyeodream.domain.vo.InquiryVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper //스프링 마이바티스에서 xml파일과 연결될 Mapper 인터페이스임을 알려준다.
public interface InquiryMapper {
    // 전체 문의보기
    public List<InquiryDTO> getTotalList(Criteria criteria);
    // 자유게시판 글 개수
    public int getTotal();
    // 문의 상세 조회
    public InquiryDTO getList(int inquiryNumber);
    // 스터디 만든 회원의 닉네임 찾기
    public String selectNickName(int inquiryMemberNumber);
    // 문의하기 작성
    public void insert(InquiryVO inquiryVO);
    // 문의하기 수정
    public int update(InquiryVO inquiryVO);
    // 문의하기 삭제
    public int delete(int inquiryNumber);
    // 조회수 수정
    public int visit(int inquiryNumber);
    // 문의하기 답변
    public void answer(InquiryVO inquiryVO);

    // 답변 대기 중인 문의글
    public List<InquiryDTO> getApproveWait();

}
