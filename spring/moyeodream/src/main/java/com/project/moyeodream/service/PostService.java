package com.project.moyeodream.service;

import com.project.moyeodream.domain.vo.Criteria;
import com.project.moyeodream.domain.vo.PostDTO;
import com.project.moyeodream.domain.vo.PostVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    // 게시판 전체 목록
    public List<PostDTO> getList(Criteria criteria);

    // 게시판 글 개수
    public int getTotal(Criteria criteria);

    public List<PostVO> getCategoryList(String postCategory);

    // 게시글 상세보기
    public PostDTO postRead(int postNumber);

    public PostVO myPost(int postNumber);

    // 게시판 글 등록
    public void postRegister(PostVO postVO);

    public void postUpdate(PostVO postVO);

    public void postDelete(int postNumber);
}
