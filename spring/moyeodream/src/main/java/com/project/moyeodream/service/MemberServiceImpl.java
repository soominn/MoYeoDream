package com.project.moyeodream.service;

import com.project.moyeodream.domain.dao.MemberDAO;
import com.project.moyeodream.domain.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Qualifier("member")
public class MemberServiceImpl implements MemberService{

    private MemberDAO memberDAO;

    @Override
    public void join(MemberVO memberVO) {
        memberDAO.join(memberVO);
    }

    @Override
    public MemberVO myPageView(int memberNumber) {
        return memberDAO.myPageView(memberNumber);
    }

    @Override
    public boolean memberModify(MemberVO memberVO) {
        return memberDAO.memberModify(memberVO);
    }

    @Override
    public boolean memberDelete(int memberNumber) {
        return memberDAO.memberDelete(memberNumber);
    }
}
