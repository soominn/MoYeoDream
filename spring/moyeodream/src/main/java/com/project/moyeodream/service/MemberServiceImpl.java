package com.project.moyeodream.service;

import com.project.moyeodream.domain.dao.FileDAO;
import com.project.moyeodream.domain.dao.MemberDAO;
import com.project.moyeodream.domain.dao.PostCommentDAO;
import com.project.moyeodream.domain.dao.StudyCommentDAO;
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
    private final PostCommentDAO postCommentDAO;
    private final StudyCommentDAO studyCommentDAO;

    @Override
    public void join(MemberVO memberVO) {
        memberDAO.join(memberVO);
    }

    @Override
    public int login(String memberEmail){return memberDAO.login(memberEmail);}

    @Override
    public boolean checkEmail(String memberEmail){return memberDAO.checkEmail(memberEmail);}

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
    public List<StudyDTO> getMyStudyList(int memberNumber) {
        List<StudyDTO> studyList = memberDAO.getMyStudyList(memberNumber);
        studyList.forEach( study -> {
            // 댓글 개수 구하기
            int commentCount = studyCommentDAO.getTotal(study.getStudyNumber());
            study.setStudyCommentTotal(commentCount);
        });
        return studyList;
    }

    @Override
    public int selectMyStudy1(int memberNumber) { return memberDAO.selectMyStudy1(memberNumber); }

    @Override
    public int selectMyStudy0(int memberNumber) { return memberDAO.selectMyStudy0(memberNumber); }

    // 내 게시글 목록
    @Override
    public List<PostDTO> getMyPostList(int memberNumber, Criteria criteria) {
        List<PostDTO> postList = memberDAO.getMyPostList(memberNumber, criteria);
        postList.forEach( post -> {
            // 댓글 개수 구하기
            int commentCount = postCommentDAO.getReplyTotal(post.getPostNumber());
            post.setPostCommentCount(commentCount);
        });
        return postList;
    }

    // 내 게시글 개수
    @Override
    public int getMyPostCount(int memberNumber) { return memberDAO.getMyPostCount(memberNumber); }


    // 선택된 게시글 삭제
    @Override
    public void deleteBoard(List<String> boardIdxArray) { memberDAO.deleteBoard(boardIdxArray); }


    // 내 댓글 목록
    @Override
    public List<PostDTO> getMyCommentList(int memberNumber, Criteria criteria) {
        List<PostDTO> postList = memberDAO.getMyCommentList(memberNumber, criteria);
        postList.forEach( post -> {
            // 댓글 개수 구하기
            int commentCount = postCommentDAO.getReplyTotal(post.getPostNumber());
            post.setPostCommentCount(commentCount);
        });
        return postList;
    }

    // 내 댓글 개수
    @Override
    public int getMyCommentCount(int memberNumber) { return memberDAO.getMyCommentCount(memberNumber); }
}
