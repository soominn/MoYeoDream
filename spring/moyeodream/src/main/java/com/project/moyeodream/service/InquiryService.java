package com.project.moyeodream.service;

import com.project.moyeodream.domain.vo.InquiryVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InquiryService {

    public List<InquiryVO> getTotalList();

    public InquiryVO getList(int inquiryNumber);

    public void inquiryInsert(InquiryVO inquiryVO);

    public boolean inquiryModify(InquiryVO inquiryVO);

    public boolean inquiryDelete(int inquiryNumber);

    public void answer(InquiryVO inquiryVO);
}
