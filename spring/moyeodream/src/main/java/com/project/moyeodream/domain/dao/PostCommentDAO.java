package com.project.moyeodream.domain.dao;

import com.project.moyeodream.domain.vo.PostCommentVO;
import com.project.moyeodream.mapper.PostCommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostCommentDAO {
    private PostCommentMapper postCommentMapper;

    // 댓글 작성
    public void postCommentRegister(PostCommentVO postCommentVO){
        postCommentMapper.insert(postCommentVO);
    }

    // 댓글 수정
    public boolean postCommentUpdate(PostCommentVO postCommentVO){
        return postCommentMapper.update(postCommentVO) == 1;
    }

    // 댓글 삭제
    public boolean postCommentDelete(int postCommentNumber){
        return postCommentMapper.delete(postCommentNumber) == 1;
    }

    // 전체 댓글 목록
    public List<PostCommentVO> postCommentList(){
        return postCommentMapper.getlist();
    }

}
