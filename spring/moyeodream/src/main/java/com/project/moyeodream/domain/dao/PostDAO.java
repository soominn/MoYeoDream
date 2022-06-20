package com.project.moyeodream.domain.dao;

import com.project.moyeodream.domain.vo.JobpostingVO;
import com.project.moyeodream.domain.vo.PostVO;
import com.project.moyeodream.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostDAO {

    private PostMapper postMapper;

    // 전체 자유 게시판 목록
    public List<PostVO> getList(){
        return postMapper.getList();
    }

    // 카테고리 별 스터디
    public List<PostVO> getCategoryList(String postCategory){
        return postMapper.getCategoryList(postCategory);
    }

    // 자유 게시판 조회
    public PostVO postRead(int postNumber){
        return postMapper.read(postNumber);
    }

    // 내 자유 게시판 글 확인
    public PostVO myPost(int postNumber){
        return postMapper.myPost(postNumber);
    }

    // 자유 게시판 작성
    public void postInsert(PostVO postVO){
        postMapper.insert(postVO);
    }

    // 자유 게시판 수정
    public boolean postUpdate(PostVO postVO){
        return postMapper.update(postVO) == 1;
    }

    // 자유 게시판 삭제
    public boolean postDelete(int postNumber){
        return postMapper.delete(postNumber) == 1;
    }

}
