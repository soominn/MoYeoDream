package com.project.moyeodream.mapper;

import com.project.moyeodream.domain.vo.Criteria;
import com.project.moyeodream.domain.vo.PostDTO;
import com.project.moyeodream.domain.vo.PostVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class PostMapperTests {

    @Autowired
    private PostMapper postMapper;

    /* 게시판 전체목록 테스트 */
//    @Test
    public void getListTest(){
        log.info("-----------------------------------------");
        log.info("mapper getList...........");
        log.info("-----------------------------------------");

        Criteria criteria = new Criteria();
        List<PostDTO> list = postMapper.getList(criteria);
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

    // 게시글 조회수 올리기 테스트
    @Test
    public void viewUp(){
        log.info("-----------------------------------------");
        log.info("mapper read..........");
        log.info("-----------------------------------------");

        int postNumber = 2;
        postMapper.viewUp(postNumber);
        log.info("게시글 번호 : " + postMapper.read(postNumber));
    }

    // 게시글 조회 테스트
//    @Test
    public void readTest(){
        log.info("-----------------------------------------");
        log.info("mapper read..........");
        log.info("-----------------------------------------");

        postMapper.read(145);
        log.info("게시글 번호 : "+ postMapper.read(145).getPostNumber());
    }

    // 게시글 수정 완료 테스트
//    @Test
    public void modifyOkTest(){
        log.info("-----------------------------------------");
        log.info("mapper modifyOk..........");
        log.info("-----------------------------------------");

        PostVO postVO = new PostVO();
        postVO.setPostTitle("맵퍼 테스트 제목");
        postVO.setPostContent("맵퍼 테스트 - 수정 완료");
        postVO.setPostNumber(2);

        postMapper.update(postVO);
        log.info(postVO.getPostNumber() + "번 게시글 수정 완료");
    }
}
