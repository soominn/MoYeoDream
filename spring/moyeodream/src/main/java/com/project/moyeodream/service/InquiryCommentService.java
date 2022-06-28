package com.project.moyeodream.service;

import com.project.moyeodream.domain.dao.InquiryCommentDAO;
import com.project.moyeodream.domain.vo.Criteria;
import com.project.moyeodream.domain.vo.InquiryCommentVO;
import com.project.moyeodream.domain.vo.StudyCommentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("comment")
public class InquiryCommentService {
    private final InquiryCommentDAO inquiryCommentDAO;

    // 댓글 작성
    public void inquiryCommentRegister(InquiryCommentVO inquiryCommentVO) {
        inquiryCommentDAO.inquiryCommentRegister(inquiryCommentVO);
    }

    // 댓글 수정
    public boolean inquiryCommentUpdate(InquiryCommentVO inquiryCommentVO) {
        return inquiryCommentDAO.inquiryCommentUpdate(inquiryCommentVO);
    }

    // 댓글 삭제
    public boolean inquiryCommentDelete(int inquiryCommentNumber) {
        return inquiryCommentDAO.inquiryCommentDelete(inquiryCommentNumber);
    }


    // 전체 댓글 목록 조회
    public List<InquiryCommentVO> inquiryCommentList(int inquiryNumber) {
        List<InquiryCommentVO> inquiryCommentVOS = inquiryCommentDAO.inquiryCommentList(inquiryNumber);
        inquiryCommentVOS.forEach(VO -> {
            VO.setCommentTotal(inquiryCommentDAO.getTotal(inquiryNumber));
        });
        return inquiryCommentVOS;
    }
}
