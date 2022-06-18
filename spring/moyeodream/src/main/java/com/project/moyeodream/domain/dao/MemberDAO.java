package com.project.moyeodream.domain.dao;

import com.project.moyeodream.domain.vo.MemberVO;
import com.project.moyeodream.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberDAO {
    private MemberMapper memberMapper;

    // 회원 가입
    public void join(MemberVO memberVO){
        memberMapper.insert(memberVO);
    }
    // 내 정보 보기
    public MemberVO myPageView(int memberNumber){
        return memberMapper.select(memberNumber);
    }
    // 내 정보 수정
    public boolean memberModify(MemberVO memberVO){
        return memberMapper.update(memberVO) == 1;
    }

    // 회원 탈퇴
    public boolean memberDelete(int memberNumber){
        return memberMapper.delete(memberNumber) == 1;
    }

}
