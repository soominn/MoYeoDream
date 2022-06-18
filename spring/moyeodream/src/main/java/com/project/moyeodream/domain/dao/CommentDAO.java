package com.project.moyeodream.domain.dao;

import com.project.moyeodream.domain.vo.CommentVO;
import com.project.moyeodream.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentDAO {
    private CommentMapper commentMapper;

    // 댓글 작성
    public void commentRegister(CommentVO commentVO){
        commentMapper.insert(commentVO);
    }

    // 댓글 수정
    public boolean commentUpdate(CommentVO commentVO){
        return commentMapper.update(commentVO) == 1;
    }

    // 댓글 삭제
    public boolean commentDelete(int commentNumber){
        return commentMapper.delete(commentNumber) == 1;
    }

    // 전체 댓글 목록
    public List<CommentVO> commenList(){
        return commentMapper.getlist();
    }

}
