package com.project.moyeodream.service;

import com.project.moyeodream.domain.dao.CommentDAO;
import com.project.moyeodream.domain.vo.CommentVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("comment")
public class CommentServiceImpl implements CommentSevice{

    private CommentDAO commentDAO;

    @Override
    public void commentRegister(CommentVO commentVO) {
        commentDAO.commentRegister(commentVO);
    }

    @Override
    public boolean commentUpdate(CommentVO commentVO) {
        return commentDAO.commentUpdate(commentVO);
    }

    @Override
    public boolean commentDelete(int commentNumber) {
        return commentDAO.commentDelete(commentNumber);
    }

    @Override
    public List<CommentVO> commenList() {
        return commentDAO.commenList();
    }
}
