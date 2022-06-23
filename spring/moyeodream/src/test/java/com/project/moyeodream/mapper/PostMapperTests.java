package com.project.moyeodream.mapper;

import com.project.moyeodream.domain.vo.PostDTO;
import com.project.moyeodream.domain.vo.PostVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class PostMapperTests {

    @Autowired
    private PostMapper postMapper;

    /* 게시판 전체목록 테스트 */
    @Test
    public void getListTest(){
        log.info("-----------------------------------------");
        log.info("mapper getList...........");
        log.info("-----------------------------------------");

        List<PostDTO> list = postMapper.getList();
        log.info(list.toString());
    }

    /*  게시글 등록 테스트 */
//    @Test
    public void insertTest(){
        log.info("-----------------------------------------");
        log.info("mapper  insert..........");
        log.info("-----------------------------------------");

        for(int i = 1; i < 11 ; i ++){
            PostVO postVO = new PostVO();
            postVO.setPostMemberNumber(i);
            postVO.setPostContent("단위테스트 진행중"+ i);
            postVO.setPostCategory("테스트" + i);
            postVO.setPostTitle("단위테스트" + i);

            postMapper.insert(postVO);
            log.info("postVO" +  i + " 등록 완료");
        }
    }
}
