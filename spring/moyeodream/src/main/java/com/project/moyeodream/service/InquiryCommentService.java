package com.project.moyeodream.service;

import com.project.moyeodream.domain.vo.InquiryCommentVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface InquiryCommentService {

    public void inquiryCommentRegister(InquiryCommentVO inquiryCommentVO);

    public boolean inquiryCommentUpdate(InquiryCommentVO inquiryCommentVO);

    public boolean inquiryCommentDelete(int inquiryCommentNumber);

    public List<InquiryCommentVO> inquiryCommentList();
}
