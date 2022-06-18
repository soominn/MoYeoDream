package com.project.moyeodream.mapper;

import com.project.moyeodream.domain.vo.JobpostingVO;
import com.project.moyeodream.domain.vo.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper //스프링 마이바티스에서 xml파일과 연결될 Mapper 인터페이스임을 알려준다.
public interface PostMapper {
    // 전체 자유 게시판 목록
    public List<PostVO> getList();
    // 자유 게시판 조회
    public JobpostingVO read(PostVO PostVO);
    // 내 자유 게시판 글 확인
    public JobpostingVO myPost(int postNumber);
    // 자유 게시판 작성
    public void insert(PostVO PostVO);
    // 자유 게시판 수정
    public int update(PostVO PostVO);
    // 자유 게시판 삭제
    public int delete(int postNumber);
}
