package com.project.moyeodream.controller;

import com.project.moyeodream.domain.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@Slf4j
public class PostControllerTests {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

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
    @Test
    public void getListTest() throws Exception{
        log.info(
          mockMvc.perform(MockMvcRequestBuilders.get("/post/list")
          .param("pageNum", "1")
          .param("amount", "10"))
                  .andReturn().getModelAndView().getModel().toString()
        );
    }

}
