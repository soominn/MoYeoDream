package com.project.moyeodream.service;

import com.project.moyeodream.domain.vo.Criteria;
import com.project.moyeodream.domain.vo.MemberVO;
import com.project.moyeodream.domain.vo.PostDTO;
import com.project.moyeodream.domain.vo.StudyDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberService {

    public void join(MemberVO memberVO);
    public int login(String memberEmail);
    public boolean checkEmail(String memberEmail);
    public String checkImg(int memberNumber);
    public MemberVO myPageView(int memberNumber);
    public boolean memberModify(MemberVO memberVO);
    public boolean memberDelete(int memberNumber);

    public List<StudyDTO> getMyStudyList(int memberNumber);

    public int selectMyStudy1(int memberNumber);

    public int selectMyStudy0(int memberNumber);

    // 내 게시글 목록
    public List<PostDTO> getMyPostList(int memberNumber, Criteria criteria);

    // 내 게시글 개수
    public int getMyPostCount(int memberNumber);

    // 선택된 게시글 삭제
    public void deleteBoard(List<String> boardIdxArray);

    // 내 댓글 목록
    public List<PostDTO> getMyCommentList(int memberNumber, Criteria criteria);

    // 내 댓글 개수
    public int getMyCommentCount(int memberNumber);

}
