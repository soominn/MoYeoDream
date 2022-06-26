package com.project.moyeodream.service;

import com.project.moyeodream.domain.dao.AdminDAO;
import com.project.moyeodream.domain.dao.JobpostingDAO;
import com.project.moyeodream.domain.vo.AdminVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class JobpostingServiceTests {
    @Autowired
    private JobpostingService jobpostingService;

    @Test
    public void approveWaitTest() {
        log.info("승인 안된 채용 공고 : " + jobpostingService.approveWait());
    }
}
