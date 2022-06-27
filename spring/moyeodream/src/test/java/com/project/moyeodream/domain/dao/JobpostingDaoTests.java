package com.project.moyeodream.domain.dao;

import com.project.moyeodream.domain.vo.AdminVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class JobpostingDaoTests {
    @Autowired
    private JobpostingDAO jobpostingDAO;

    @Test
    public void approveWaitTest() {
        log.info("채용 공고 : "+jobpostingDAO.approveWait().toString());
    }
}
