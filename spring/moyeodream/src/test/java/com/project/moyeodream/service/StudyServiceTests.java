package com.project.moyeodream.service;

import com.project.moyeodream.domain.dao.StudyDAO;
import com.project.moyeodream.domain.vo.StudyVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class StudyServiceTests {
    @Autowired
    private StudyDAO studyDAO;

    @Test
    public void registerTest() {
        StudyVO studyVO = new StudyVO();
        studyVO.setStudyCategory("computer");
        studyVO.setStudyProcess("online");
        studyVO.setStudyPersonnel("three");
        studyVO.setStudyStart("2022-06-30");
        studyVO.setStudyCommunication("http://kakaoOpenChat.com");
        studyVO.setStudyPeriod("twoMonths");
        studyVO.setStudyChief("스터디장 소개 테스트");
        studyVO.setStudyTitle("자바 스터디 어렵지 않습니다!");
        studyVO.setStudyContent("스터디 소개 테스트");
        studyVO.setStudyMemberNumber(1);

        studyDAO.register(studyVO);
        log.info("---------------------------------------------------------");
        log.info("추가된 스터디 번호 : " + studyVO.getStudyNumber());
        log.info("---------------------------------------------------------");
    }

    @Test
    public void readTest() {
        log.info("---------------------------------------------------------");
        log.info("추가된 스터디 Title : " + studyDAO.read(1).getStudyTitle());
        log.info("---------------------------------------------------------");
    }

    @Test
    public void viewsTest() {
        log.info("---------------------------------------------------------");
        studyDAO.views(1);
        log.info("---------------------------------------------------------");
    }
}
