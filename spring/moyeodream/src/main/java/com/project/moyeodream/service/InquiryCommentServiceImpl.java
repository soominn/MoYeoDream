package com.project.moyeodream.service;

import com.project.moyeodream.domain.dao.InquiryCommentDAO;
import com.project.moyeodream.domain.vo.InquiryCommentVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("comment")
public class InquiryCommentServiceImpl implements InquiryCommentService {

    private InquiryCommentDAO inquiryCommentDAO;

    @Override
    public void inquiryCommentRegister(InquiryCommentVO inquiryCommentVO) {
        inquiryCommentDAO.inquiryCommentRegister(inquiryCommentVO);
    }

    @Override
    public boolean inquiryCommentUpdate(InquiryCommentVO inquiryCommentVO) {
        return inquiryCommentDAO.inquiryCommentUpdate(inquiryCommentVO);
    }

    @Override
    public boolean inquiryCommentDelete(int inquiryCommentNumber) {
        return inquiryCommentDAO.inquiryCommentDelete(inquiryCommentNumber);
    }

    @Override
    public List<InquiryCommentVO> inquiryCommentList() {
        return inquiryCommentDAO.inquiryCommentList();
    }
}
