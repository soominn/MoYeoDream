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
    public int getTotal();

    public List<PostVO> getCategoryList(String postCategory);

    public PostVO postRead(int postNumber);

    public PostVO myPost(int postNumber);

    // 게시판 글 등록
    public void postRegister(PostVO postVO);

    public boolean postUpdate(PostVO postVO);

    public boolean postDelete(int postNumber);
}
