package com.project.moyeodream.service;

import com.project.moyeodream.domain.vo.PostCommentVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface PostCommentService {

    public void postCommentRegister(PostCommentVO postCommentVO);

    public boolean postCommentUpdate(PostCommentVO postCommentVO);

    public boolean postCommentDelete(int postCommentNumber);

    public List<PostCommentVO> postCommentList();
}
