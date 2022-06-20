package com.project.moyeodream.service;

import com.project.moyeodream.domain.vo.MemberVO;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {

    public void join(MemberVO memberVO);
    public MemberVO myPageView(int memberNumber);
    public boolean memberModify(MemberVO memberVO);
    public boolean memberDelete(int memberNumber);
}
