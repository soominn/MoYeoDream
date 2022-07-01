package com.project.moyeodream.service;

import com.project.moyeodream.domain.vo.Criteria;
import com.project.moyeodream.domain.vo.InquiryDTO;
import com.project.moyeodream.domain.vo.InquiryVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InquiryService {

    public List<InquiryDTO> getTotalList(Criteria criteria);

    // 게시판 글 개수
    public int getTotal();

    public InquiryDTO getList(int inquiryNumber);

    public void inquiryInsert(InquiryVO inquiryVO);

    public boolean inquiryModify(InquiryVO inquiryVO);

    public boolean inquiryDelete(int inquiryNumber);

    public boolean inquiryVisit(int inquiryNumber);

    public void answer(InquiryVO inquiryVO);

    public List<InquiryDTO> approveWait();

    public List<InquiryDTO> getInqList(Criteria criteria);

    public int getTotalAdmin(Criteria criteria);

    public InquiryDTO adInqRead(int inquiryNumber);
}
