package com.project.moyeodream.mapper;

import com.project.moyeodream.domain.vo.InquiryCommentVO;
import com.project.moyeodream.domain.vo.PostCommentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper //스프링 마이바티스에서 xml파일과 연결될 Mapper 인터페이스임을 알려준다.
public interface InquiryCommentMapper {
    // 댓글 작성
    public void insert(InquiryCommentVO inquiryCommentVO);
    // 댓글 수정
    public int update(InquiryCommentVO inquiryCommentVO);
    // 댓글 삭제
    public int delete(int inquiryCommentNumber);
    // 전체 댓글 목록
    public List<InquiryCommentVO> getlist();


}
