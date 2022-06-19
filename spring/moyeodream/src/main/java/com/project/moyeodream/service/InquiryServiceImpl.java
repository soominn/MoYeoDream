package com.project.moyeodream.service;

import com.project.moyeodream.domain.dao.InquiryDAO;
import com.project.moyeodream.domain.vo.InquiryVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("inquiry")
public class InquiryServiceImpl implements InquiryService{

    private InquiryDAO inquiryDAO;

    @Override
    public List<InquiryVO> getTotalList() {
        return inquiryDAO.getTotalList();
    }

    @Override
    public InquiryVO getList(int inquiryNumber) {
        return inquiryDAO.getList(inquiryNumber);
    }

    @Override
    public void inquiryInsert(InquiryVO inquiryVO) {
        inquiryDAO.inquiryInsert(inquiryVO);
    }

    @Override
    public boolean inquiryModify(InquiryVO inquiryVO) {
        return inquiryDAO.inquiryModify(inquiryVO);
    }

    @Override
    public boolean inquiryDelete(int inquiryNumber) {
        return inquiryDAO.inquiryDelete(inquiryNumber);
    }

    @Override
    public void answer(InquiryVO inquiryVO) {
        inquiryDAO.answer(inquiryVO);
    }
}
