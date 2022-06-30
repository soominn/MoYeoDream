package com.project.moyeodream.domain.dao;

import com.project.moyeodream.domain.vo.PostCommentVO;
import com.project.moyeodream.mapper.PostCommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostCommentDAO {

    private final PostCommentMapper postCommentMapper;

    // 전체 댓글 목록
    public List<PostCommentVO> getReplyList (Integer postNumber){
        return postCommentMapper.getReplyList(postNumber);
    }

    // 전체 댓글 개수
    public int getReplyTotal (Integer postNumber){
        return postCommentMapper.getReplyTotal(postNumber);
    }

    // 댓글 1개 가져오기
    public PostCommentVO getReply (Integer postCommentNumber){
        return postCommentMapper.readReply(postCommentNumber);
    }

    // 댓글 등록
    public void registerReply(PostCommentVO postCommentVO){
        postCommentMapper.createReply(postCommentVO);
    }

    // 댓글 수정
    public boolean modifyReply(PostCommentVO postCommentVO){
        return postCommentMapper.updateReply(postCommentVO) == 1;
    }

    // 댓글 삭제
    public boolean removeReply(Integer postCommentNumber){
        return postCommentMapper.deleteReply(postCommentNumber) == 1;
    }

    // 내 댓글 보기
    public List<PostCommentVO> myList(Integer memberNumber){
        return postCommentMapper.myList(memberNumber);
    }

}
