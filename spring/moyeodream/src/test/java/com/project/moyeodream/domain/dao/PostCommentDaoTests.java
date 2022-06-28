package com.project.moyeodream.domain.dao;

import com.project.moyeodream.domain.vo.Criteria;
import com.project.moyeodream.domain.vo.PostCommentVO;
import com.project.moyeodream.domain.vo.PostVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class PostCommentDaoTests {

    @Autowired
    private PostCommentDAO postCommentDAO;

    // 댓글 등록
//    @Test
    public void registerTest(){
        log.info("----------------------------------");
        log.info("replyDAO register Test.......");
        log.info("----------------------------------");
        PostCommentVO postCoVO = new PostCommentVO();
        postCoVO.setPostCommentContent("ReplyDAO register 테스트");
        postCoVO.setPostCommentMemberNumber(1);
        postCoVO.setPostCommentPostNumber(2);

        postCommentDAO.registerReply(postCoVO);
        log.info("작성된 댓글 번호 : " + postCoVO.getPostCommentNumber());
    }

    // 댓글 수정
//    @Test
    public void modifyTest(){
        log.info("----------------------------------");
        log.info("replyDAO modify Test.......");
        log.info("----------------------------------");

        PostCommentVO postCoVO = new PostCommentVO();
        postCoVO.setPostCommentContent("ReplyDAO modify 테스트");
        postCoVO.setPostCommentNumber(3);

        postCommentDAO.modifyReply(postCoVO);
        log.info("댓글 수정 완료");
    }

    // 댓글 삭제
//    @Test
    public void removeTest(){
        log.info("----------------------------------");
        log.info("replyDAO remove Test.......");
        log.info("----------------------------------");

        postCommentDAO.removeReply(4);
        log.info("댓글 삭제 완료");
    }

    // 댓글 1개 가져오기
//    @Test
    public void readReplyTest(){
        log.info("----------------------------------");
        log.info("replyDAO readReply Test.......");
        log.info("----------------------------------");

        log.info(postCommentDAO.getReply(2).toString());
    }

    // 댓글 전체 목록 가져오기
//    @Test
    public void getList(){
        log.info("----------------------------------");
        log.info("replyDAO getList Test.......");
        log.info("----------------------------------");

        log.info(postCommentDAO.getReplyList(2).toString());
    }

    // 댓글 개수 가져오기
//    @Test
    public void getListTotal(){
        log.info("----------------------------------");
        log.info("replyDAO getListTotal Test.......");
        log.info("----------------------------------");

        log.info("댓글 개수 : "+postCommentDAO.getReplyTotal(2));
    }

}
