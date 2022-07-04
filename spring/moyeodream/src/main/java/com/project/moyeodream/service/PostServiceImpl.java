package com.project.moyeodream.service;

import com.project.moyeodream.domain.dao.FileDAO;
import com.project.moyeodream.domain.dao.PostCommentDAO;
import com.project.moyeodream.domain.dao.PostDAO;
import com.project.moyeodream.domain.vo.Criteria;
import com.project.moyeodream.domain.vo.PostDTO;
import com.project.moyeodream.domain.vo.PostVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("post")
@Slf4j
public class PostServiceImpl implements PostService{

    private final PostDAO postDAO;
    private final PostCommentDAO postCommentDAO;
    private final FileDAO fileDAO;

    // 게시판 전체 목록
    @Override
    public List<PostDTO> getList(Criteria criteria) {
        List<PostDTO> postList = postDAO.getList(criteria);
        postList.forEach( post -> {
            // 댓글 개수 구하기
            int commentCount = postCommentDAO.getReplyTotal(post.getPostNumber());
            post.setPostCommentCount(commentCount);
        });
        return postList;
    }

    // 게시판 글 개수
    @Override
    public int getTotal(Criteria criteria) {
        return postDAO.getTotal(criteria);
    }
    @Override
    public List<PostVO> getCategoryList(String postCategory) {
        return postDAO.getCategoryList(postCategory);
    }

    // 게시글 상세조회
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PostDTO postRead(int postNumber) {
        // 조회수 1up 먼저 해준 후
        postDAO.viewUp(postNumber);

        // 게시글 가져오기
        PostDTO postDTO = postDTO = postDAO.postRead(postNumber);
        // 파일 가져오기
        postDTO.setFileList(fileDAO.getFileList(postDTO.getPostNumber()));
        log.info("받아온 fileLsit : "+ fileDAO.getFileList(postDTO.getPostNumber()));

        // 해당 postNumber의 DB를 읽어온다.
        return postDTO;
    }

    @Override
    public PostVO myPost(int postNumber) {
        return postDAO.myPost(postNumber);
    }

    // 게시글 등록 완료
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void postRegister(PostVO postVO) {

        postDAO.postRegister(postVO);
        if(postVO.getFileList() != null){
            log.info(postVO.getFileList().toString());
            postVO.getFileList().forEach(fileVO -> {
                fileVO.setPostVO(postVO);
                fileDAO.save(fileVO);
            });
        }
    }

    // 게시글 수정 완료
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void postUpdate(PostVO postVO) {
        postDAO.postUpdate(postVO);
        if(postVO.getFileList() != null){
            // 전체 삭제 후
            fileDAO.remove(postVO.getPostNumber());

            // 새로 저장
            postVO.getFileList().forEach(fileVO -> {
               fileVO.setPostVO(postVO);
               fileDAO.save(fileVO);
            });
        }
    }

    //  게시글 삭제 완료
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void postDelete(int postNumber) {
        postDAO.postDelete(postNumber);
        fileDAO.remove(postNumber);
    }
}
