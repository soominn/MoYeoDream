package com.project.moyeodream.controller;

import com.project.moyeodream.domain.dao.PostDAO;
import com.project.moyeodream.domain.vo.*;
import com.project.moyeodream.mapper.PostMapper;
import com.project.moyeodream.service.PostService;
import com.project.moyeodream.service.PostServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@SpringBootTest
@Slf4j
public class PostControllerTests {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;
    private PostDAO postDAO;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /* 게시글 등록 */
//    @Test
    public void registerTest() throws Exception{
        log.info(
                mockMvc.perform(MockMvcRequestBuilders.post("/post/postRegister")
                        .param("postTitle","regTest 제목")
                        .param("postCategory","free-talking")
                        .param("postContent","regTest 내용")
                        .param("postMemberNumber","0"))
                        .andReturn().getFlashMap().toString()
                                    /* flashMap 에 postNumber 담아온 것 확인 */
        );
    }

    /* 게시글 목록 가져오기 */
//    @Test
    public void getListTest() throws Exception{

        log.info(
          mockMvc.perform(MockMvcRequestBuilders.get("/get/list")
          .param("criteria", new Criteria().toString()))
                  .andReturn().getModelAndView().getModel().toString()
        );
    }

    // 게시글 상세보기
//    @Test
    public void readTest() throws Exception{
        log.info(
          mockMvc.perform(MockMvcRequestBuilders.get("/post/read")
          .param("postNumber", "145")
          .param("criteria", new Criteria().toString()))
                .andReturn().getModelAndView().getModel().toString()
        );
    }

    // 게시글 수정화면 불러오기
//    @Test
    public void goModifyTest() throws Exception{
        log.info(
         mockMvc.perform(MockMvcRequestBuilders.get("/post/modify")
         .param("postNumber", "146")
         .param("criteria", new Criteria().toString()))
                .andReturn().getModelAndView().getModel().toString()
        );
    }

    // 게시글 수정 완료
//    @Test
    public void modifyOkTest() throws Exception{
        log.info(
            mockMvc.perform(MockMvcRequestBuilders.post("/post/modify")
                    .param("postTitle", "수정완료 컨트롤러 단위테스트")
                    .param("postContent", "modifyOk controller 단위테스트")
                    .param("postNumber", "130")
                    .param("criteria", new Criteria().toString()))
                    .andReturn().getModelAndView().getModel().toString()
        );
    }

    // 게시글 삭제
//    @Test
    public void deleteTest() throws Exception{
        log.info(
                mockMvc.perform(MockMvcRequestBuilders.post("/post/remove")
                        .param("postNumber","144")
                        .param("criteria", new Criteria().toString()))
                        .andReturn().toString()
                );
        log.info("게시글 삭제 완료");
    }

}
