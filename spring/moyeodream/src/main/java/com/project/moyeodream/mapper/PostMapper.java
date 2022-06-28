package com.project.moyeodream.mapper;

import com.project.moyeodream.domain.vo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper //스프링 마이바티스에서 xml파일과 연결될 Mapper 인터페이스임을 알려준다.
public interface PostMapper {
    // 전체 자유 게시판 목록
    public List<PostDTO> getList(Criteria criteria);
    // 자유게시판 글 개수
    public int getTotal(PostCriteria criteria);
    // 카테고리 별 스터디
    public List<PostVO> getCategoryList(String postCategory);
    // 게시글 조회수 올리기
    public int viewUp(int postNumber);
    // 자유 게시판 상세 조회
    public PostDTO read(int postNumber);
    // 내 자유 게시판 글 확인
    public PostVO myPost(int memberNumber);
    // 자유 게시판 작성
    public void insert(PostVO postVO);
    // 자유 게시판 수정
    public int update(PostVO postVO);
    // 자유 게시판 삭제
    public int delete(int postNumber);
}
