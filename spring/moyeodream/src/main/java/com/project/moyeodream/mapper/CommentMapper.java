package com.project.moyeodream.mapper;

import com.project.moyeodream.domain.vo.CommentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper //스프링 마이바티스에서 xml파일과 연결될 Mapper 인터페이스임을 알려준다.
public interface CommentMapper {
    // 댓글 작성
    public void insert(CommentVO commentVO);
    // 댓글 수정
    public int update(CommentVO commentVO);
    // 댓글 삭제
    public int delete(int commentNumber);
    // 전체 댓글 목록
    public List<CommentVO> getlist();


}
