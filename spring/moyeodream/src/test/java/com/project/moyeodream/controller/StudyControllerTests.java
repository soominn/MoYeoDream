package com.project.moyeodream.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@Slf4j
@SpringBootTest
public class StudyControllerTests {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void registerTest() throws Exception {
        log.info(mockMvc.perform(MockMvcRequestBuilders.post("/study/register")
                .param("studyCategory", "computer")
                .param("studyProcess", "online")
                .param("studyPersonnel", "three")
                .param("studyStart", "2022-06-30")
                .param("studyCommunication", "http://kakaoOpenChat.com")
                .param("studyPeriod", "hds1234")
                .param("studyCategory", "twoMonths")
                .param("studyChief", "스터디장 소개 테스트")
                .param("studyTitle", "스터디 제목 테스트")
                .param("studyContent", "스터디 소개 테스트")
                .param("studyMemberNumber", "1")).andReturn().getFlashMap().toString());
    }
}
