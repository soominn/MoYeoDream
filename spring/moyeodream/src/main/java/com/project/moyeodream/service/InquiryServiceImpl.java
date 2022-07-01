package com.project.moyeodream.service;

import com.project.moyeodream.domain.dao.InquiryDAO;
import com.project.moyeodream.domain.vo.Criteria;
import com.project.moyeodream.domain.vo.InquiryDTO;
import com.project.moyeodream.domain.vo.InquiryVO;
import com.project.moyeodream.domain.vo.PostVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("inquiry") @Primary
public class InquiryServiceImpl implements InquiryService{

    private final InquiryDAO inquiryDAO;

    @Override
    public List<InquiryDTO> getTotalList(Criteria criteria) {
        return inquiryDAO.getTotalList(criteria);
    }

    // 게시판 글 개수
    @Override
    public int getTotal() {
        return inquiryDAO.getTotal();
    }

    @Override
    public InquiryDTO getList(int inquiryNumber) {
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
    public boolean inquiryVisit(int inquiryNumber) {
        return inquiryDAO.inquiryVisit(inquiryNumber);
    }

    @Override
    public void answer(InquiryDTO inquiryDTO) {
        inquiryDAO.answer(inquiryDTO);
    }

    @Override
    public List<InquiryDTO> approveWait(){
        return inquiryDAO.approveWait();
    };

    @Override
    public List<InquiryDTO> getInqList(Criteria criteria) { return inquiryDAO.getInqList(criteria); }

    @Override
    public int getTotalAdmin(Criteria criteria){
        return inquiryDAO.getTotalAdmin(criteria);
    }

    @Override
    public InquiryDTO adInqRead(int inquiryNumber){
        return inquiryDAO.getList(inquiryNumber);
    }

    @Override
    public boolean deleteAnswer(int inquiryNumber){
        return inquiryDAO.deleteAnswer(inquiryNumber);
    }
}
