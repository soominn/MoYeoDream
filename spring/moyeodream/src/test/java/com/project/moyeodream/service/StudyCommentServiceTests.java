package com.project.moyeodream.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class StudyCommentServiceTests {
    @Autowired
    public StudyCommentService studyCommentService;

    @Test
    public void getListTest(){
        studyCommentService.getList(1).stream().map(comment -> comment.getStudyCommentNumber()).forEach(i -> log.info(i + ""));
    }
}
