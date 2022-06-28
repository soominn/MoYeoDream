package com.project.moyeodream.mapper;

import com.project.moyeodream.domain.vo.PostCommentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper //스프링 마이바티스에서 xml파일과 연결될 Mapper 인터페이스임을 알려준다.
public interface PostCommentMapper {

    // 게시글의 전체 댓글 개수
    public int getReplyTotal(Integer postNumber);

    // 게시글 전체 댓글 가져오기
    public List<PostCommentVO> getReplyList(Integer postNumber);

    // 댓글 1개 가져오기
    public PostCommentVO readReply(Integer postCommentNumber);

    // 댓글 등록
    public void createReply(PostCommentVO postCommentVO);

    // 댓글 수정
    public int updateReply(PostCommentVO postCommentVO);

    // 댓글 삭제
    public int deleteReply(Integer postCommentNumber);

}
