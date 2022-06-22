package com.project.moyeodream.domain.dao;

import com.project.moyeodream.domain.vo.PostVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class PostDaoTests {

    @Autowired
    private PostDAO postDAO;

    /* 게시글 추가 */
    @Test
    public void registerTest(){
        PostVO postVO = new PostVO();
        postVO.setPostTitle("테스트 제목");
        postVO.setPostCategory("테스트 카테고리");
        postVO.setPostContent("테스트 내용");

        postDAO.postRegister(postVO);
        log.info("새롭게 추가된 게시글 번호 : "+ postVO.getPostNumber());
    }

}
