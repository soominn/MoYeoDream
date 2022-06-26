package com.project.moyeodream.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class StudyCommentMapperTests {
    @Autowired
    private StudyCommentMapper studyCommentMapper;

    @Test
    public void getListTest(){
        studyCommentMapper.getList(1).stream().map(comment -> comment.getStudyCommentNumber()).forEach(i -> log.info(i + ""));
    }

    @Test
    public void selectNicknameTest() {
        log.info("nickname : " + studyCommentMapper.selectNickname(1));
    }
}
