package com.project.moyeodream.service;

import com.project.moyeodream.domain.dao.PostCommentDAO;
import com.project.moyeodream.domain.vo.PostCommentVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("comment")
public class PostCommentServiceImpl implements PostCommentService {

    private PostCommentDAO postCommentDAO;

    @Override
    public void postCommentRegister(PostCommentVO postCommentVO) {
        postCommentDAO.postCommentRegister(postCommentVO);
    }

    @Override
    public boolean postCommentUpdate(PostCommentVO postCommentVO) {
        return postCommentDAO.postCommentUpdate(postCommentVO);
    }

    @Override
    public boolean postCommentDelete(int commentNumber) {
        return postCommentDAO.postCommentDelete(commentNumber);
    }

    @Override
    public List<PostCommentVO> postCommentList() {
        return postCommentDAO.postCommentList();
    }
}
