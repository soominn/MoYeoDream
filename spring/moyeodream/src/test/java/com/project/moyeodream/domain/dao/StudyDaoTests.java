package com.project.moyeodream.domain.dao;

import com.project.moyeodream.domain.vo.StudyVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class StudyDaoTests {
    @Autowired
    private StudyDAO studyDAO;

    @Test
    public void insertTest() {
        StudyVO studyVO = new StudyVO();
        studyVO.setStudyCategory("computer");
        studyVO.setStudyProcess("online");
        studyVO.setStudyPersonnel("three");
        studyVO.setStudyStart("2022-06-30");
        studyVO.setStudyCommunication("http://kakaoOpenChat.com");
        studyVO.setStudyPeriod("twoMonths");
        studyVO.setStudyChief("스터디장 소개 테스트");
        studyVO.setStudyTitle("스터디 제목 테스트");
        studyVO.setStudyContent("스터디 소개 테스트");
        studyVO.setStudyMemberNumber(1);

        studyDAO.register(studyVO);
        log.info("추가된 게시글 번호 : " + studyVO.getStudyNumber());
    }

    @Test
    public void selectTest() {
        log.info("---------------------------------------------------------");
        log.info("찾아낸 스터디 제목 : " + studyDAO.read(1).getStudyTitle());
        log.info("---------------------------------------------------------");
    }

    @Test
    public void selectNicknameTest() {
        log.info("---------------------------------------------------------");
        log.info("member의 nickname : " + studyDAO.findNickname(1));
        log.info("---------------------------------------------------------");
    }
}
