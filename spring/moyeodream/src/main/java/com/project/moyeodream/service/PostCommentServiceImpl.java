package com.project.moyeodream.service;

import com.project.moyeodream.domain.dao.PostCommentDAO;
import com.project.moyeodream.domain.vo.PostCommentVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("postReply")
public class PostCommentServiceImpl implements PostCommentService {
    
    private final PostCommentDAO postCommentDAO;
    
    // 댓글 전체목록 가져오기
    @Override
    public List<PostCommentVO> getReplyList(Integer postNumber) {
        return postCommentDAO.getReplyList(postNumber);
    }

    // 댓글 개수 가져오기
    @Override
    public int getReplyTotal(Integer postNumber) {
        return postCommentDAO.getReplyTotal(postNumber);
    }

    // 댓글 1개 가져오기
    @Override
    public PostCommentVO getReply(Integer postCommentNumber) {
        return postCommentDAO.getReply(postCommentNumber);
    }

    // 댓글 등록
    @Override
    public void registerReply(PostCommentVO postCommentVO) {
        postCommentDAO.registerReply(postCommentVO);
    }

    // 댓글 수정
    @Override
    public boolean modifyReply(PostCommentVO postCommentVO) {
        return postCommentDAO.modifyReply(postCommentVO);
    }

    // 댓글 삭제
    @Override
    public boolean removeReply(Integer postCommentNumber) {
        return postCommentDAO.removeReply(postCommentNumber);
    }
}
