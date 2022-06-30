package com.project.moyeodream.domain.dao;

import com.project.moyeodream.domain.vo.Criteria;
import com.project.moyeodream.domain.vo.MemberVO;
import com.project.moyeodream.domain.vo.PostDTO;
import com.project.moyeodream.domain.vo.StudyDTO;
import com.project.moyeodream.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberDAO {
    private final MemberMapper memberMapper;

    // 회원 가입
    public void join(MemberVO memberVO){
        memberMapper.insert(memberVO);
    }
    // 로그인
    public int login(String memberEmail){return memberMapper.login(memberEmail);}
    // 중복된 이메일 체크
    public boolean checkEmail(String memberEmail){return memberMapper.checkEmail(memberEmail) == 1;}
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

    // 전체 내 스터디 보기
    public List<StudyDTO> getMyStudyList(int memberNumber){ return memberMapper.getMyStudyList(memberNumber); }

    // 내 승인된 스터디 개수
    public int selectMyStudy1(int memberNumber) { return memberMapper.selectMyStudy1(memberNumber); }

    // 내 대기 중인 스터디 개수
    public int selectMyStudy0(int memberNumber) { return memberMapper.selectMyStudy0(memberNumber); }


    // 내 게시물 목록
    public List<PostDTO> getMyPostList(int memberNumber, Criteria criteria){ return memberMapper.getMyPostList(memberNumber, criteria); }

    // 내 게시글 개수
    public int getMyPostCount(int memberNumber){ return memberMapper.getMyPostCount(memberNumber); }

    // 선택된 게시글 삭제
    public void deleteBoard(List<String> boardIdxArray) {
        for(int i=0; i<boardIdxArray.size(); i++) {
            memberMapper.deleteBoard(boardIdxArray.get(i));
        }
    }

    // 내 댓글 목록
    public List<PostDTO> getMyCommentList(int memberNumber, Criteria criteria){ return memberMapper.getMyCommentList(memberNumber, criteria); }

    // 내 댓글 개수
    public int getMyCommentCount(int memberNumber){ return memberMapper.getMyCommentCount(memberNumber); }

}
