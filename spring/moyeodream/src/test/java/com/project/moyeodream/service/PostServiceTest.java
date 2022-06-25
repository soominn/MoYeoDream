package com.project.moyeodream.service;

import com.project.moyeodream.domain.vo.PostCriteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class PostServiceTest {

    @Autowired
    private PostService postService;

    // 게시글 전체 목록
    @Test
    public void getList(){
        log.info("----------------------------------------");
        log.info("service getList.....................");
        log.info("----------------------------------------");

        PostCriteria criteria = new PostCriteria();
        postService.getList(criteria);
    }

    // 게시글 상세보기
//    @Test
    public void readTest(){
        log.info("----------------------------------------");
        log.info("service read.....................");
        log.info("----------------------------------------");

        log.info(postService.postRead(145).toString());
    }

    // 게시글 수정 완료
//    @Test
    public void modifyOkTest(){
        log.info("----------------------------------------");
        log.info("service modifyOk.....................");
        log.info("----------------------------------------");
    }
}
