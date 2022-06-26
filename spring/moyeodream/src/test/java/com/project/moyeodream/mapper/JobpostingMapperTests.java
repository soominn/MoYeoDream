package com.project.moyeodream.mapper;

import com.project.moyeodream.domain.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class JobpostingMapperTests {
    @Autowired
    private JobpostingMapper jobpostingMapper;

//    @Test
//    public void getApproveWaitTest() {
//        log.info("채용 공고 : "+jobpostingMapper.getApproveWait().toString());
//    }
    @Test
    public void getJobListTests() {
        log.info("채용 공고 : "+jobpostingMapper.getJobList(new Criteria()).toString());
    }

}
