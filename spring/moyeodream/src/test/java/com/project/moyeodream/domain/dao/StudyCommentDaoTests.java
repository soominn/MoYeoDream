package com.project.moyeodream.domain.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class StudyCommentDaoTests {
    @Autowired
    private StudyCommentDAO studyCommentDAO;

    @Test
    public void getListTest(){
        studyCommentDAO.getList(1).stream().map(comment -> comment.getStudyCommentNumber()).forEach(i -> log.info(i + ""));
    }
}
