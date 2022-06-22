package com.project.moyeodream.service;

import com.project.moyeodream.domain.dao.PostDAO;
import com.project.moyeodream.domain.vo.PostVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("post")
public class PostServiceImpl implements PostService{

    private final PostDAO postDAO;

    @Override
    public List<PostVO> getList() {
        return postDAO.getList();
    }

    @Override
    public List<PostVO> getCategoryList(String postCategory) {
        return postDAO.getCategoryList(postCategory);
    }

    @Override
    public PostVO postRead(int postNumber) {
        return postDAO.postRead(postNumber);
    }

    @Override
    public PostVO myPost(int postNumber) {
        return postDAO.myPost(postNumber);
    }

    /* 게시판 등록 완료 */
    @Override
    public void postRegister(PostVO postVO) {
        postDAO.postRegister(postVO);
    }

    @Override
    public boolean postUpdate(PostVO postVO) {
        return postDAO.postUpdate(postVO);
    }

    @Override
    public boolean postDelete(int postNumber) {
        return postDAO.postDelete(postNumber);
    }
}
