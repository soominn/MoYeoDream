package com.project.moyeodream.domain.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class InquiryDaoTests {
    @Autowired
    private InquiryDAO inquiryDAO;

    @Test
    public void approveWaitTest() {
        log.info("문의 사항 : "+inquiryDAO.approveWait().toString());
    }
}
