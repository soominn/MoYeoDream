package com.project.moyeodream.service;

import com.project.moyeodream.domain.vo.CommentVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface CommentSevice {

    public void commentRegister(CommentVO commentVO);

    public boolean commentUpdate(CommentVO commentVO);

    public boolean commentDelete(int commentNumber);

    public List<CommentVO> commenList();
}
