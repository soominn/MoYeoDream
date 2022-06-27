package com.project.moyeodream.service;

import com.project.moyeodream.domain.dao.MemberDAO;
import com.project.moyeodream.domain.vo.Criteria;
import com.project.moyeodream.domain.vo.MemberVO;
import com.project.moyeodream.domain.vo.PostDTO;
import com.project.moyeodream.domain.vo.StudyDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("member") @Primary
public class MemberServiceImpl implements MemberService{

    private final MemberDAO memberDAO;

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

    @Override
    public List<StudyDTO> getMyStudyList(int memberNumber) { return memberDAO.getMyStudyList(memberNumber); }

    @Override
    public int selectMyStudy1(int memberNumber) { return memberDAO.selectMyStudy1(memberNumber); }

    @Override
    public int selectMyStudy0(int memberNumber) { return memberDAO.selectMyStudy0(memberNumber); }

    // 내 게시글 목록
    @Override
    public List<PostDTO> getMyPostList(int memberNumber, Criteria criteria) { return memberDAO.getMyPostList(memberNumber, criteria); }

    // 내 게시글 개수
    @Override
    public int getMyPostCount(int memberNumber) { return memberDAO.getMyPostCount(memberNumber); }


    // 선택된 게시글 삭제
    @Override
    public void deleteBoard(List<String> boardIdxArray) { memberDAO.deleteBoard(boardIdxArray); }


}
