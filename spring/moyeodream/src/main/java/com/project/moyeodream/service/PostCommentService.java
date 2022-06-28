package com.project.moyeodream.service;

import com.project.moyeodream.domain.vo.Criteria;
import com.project.moyeodream.domain.vo.PostCommentVO;
import com.project.moyeodream.domain.vo.PostDTO;
import com.project.moyeodream.domain.vo.PostVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostCommentService {

    // 전체 댓글 목록
    public List<PostCommentVO> getReplyList (Integer postNumber);

    // 전체 댓글 개수
    public int getReplyTotal (Integer postNumber);

    // 댓글 1개 가져오기
    public PostCommentVO getReply (Integer postCommentNumber);

    // 댓글 등록
    public void registerReply(PostCommentVO postCommentVO);

    // 댓글 수정
    public boolean modifyReply(PostCommentVO postCommentVO);

    // 댓글 삭제
    public boolean removeReply(Integer postCommentNumber);

}
