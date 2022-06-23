package com.project.moyeodream.mapper;

import com.project.moyeodream.domain.vo.StudyVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class StudyMapperTests {
    @Autowired
    private StudyMapper studyMapper;

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
        studyVO.setStudyTitle("자바 스터디 어렵지 않습니다!");
        studyVO.setStudyContent("스터디 소개 테스트");
        studyVO.setStudyMemberNumber(1);

        studyMapper.insert(studyVO);
        log.info("---------------------------------------------------------");
        log.info("추가된 스터디 번호 : " + studyVO.getStudyNumber());
        log.info("---------------------------------------------------------");
    }
}
