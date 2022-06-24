package com.project.moyeodream.service;

import com.project.moyeodream.domain.dao.PostDAO;
import com.project.moyeodream.domain.vo.Criteria;
import com.project.moyeodream.domain.vo.PostDTO;
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

    // 게시판 전체 목록
    @Override
    public List<PostDTO> getList(Criteria criteria) {
        return postDAO.getList(criteria);
    }

    // 게시판 글 개수
    @Override
    public int getTotal() {
        return postDAO.getTotal();
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

    // 게시글 등록 완료
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
