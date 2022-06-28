package com.project.moyeodream.domain.dao;

import com.project.moyeodream.domain.vo.Criteria;
import com.project.moyeodream.domain.vo.InquiryCommentVO;
import com.project.moyeodream.domain.vo.StudyCommentDTO;
import com.project.moyeodream.mapper.InquiryCommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class InquiryCommentDAO {
    private final InquiryCommentMapper inquiryCommentMapper;

    // 댓글 작성
    public void inquiryCommentRegister(InquiryCommentVO inquiryCommentVO){
        inquiryCommentMapper.insert(inquiryCommentVO);
    }

    // 댓글 수정
    public boolean inquiryCommentUpdate(InquiryCommentVO inquiryCommentVO){
        return inquiryCommentMapper.update(inquiryCommentVO) == 1;
    }

    // 댓글 삭제
    public boolean inquiryCommentDelete(int inquiryCommentNumber){
        return inquiryCommentMapper.delete(inquiryCommentNumber) == 1;
    }


    // 전체 댓글 목록
    public List<InquiryCommentVO> inquiryCommentList(int inquiryNumber){
        return inquiryCommentMapper.getlist(inquiryNumber);
    }

    // 댓글 총개수
    public int getTotal(int inquiryNumber) {
        return inquiryCommentMapper.getTotal(inquiryNumber);
    };

}
