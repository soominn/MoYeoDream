package com.project.moyeodream.mapper;

import com.project.moyeodream.domain.vo.AdminVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class AdminMapperTests {
    @Autowired
    private AdminMapper adminMapper;

    @Test
    public void loginTest() {
        AdminVO adminVO = new AdminVO();
        adminVO.setAdminId("admin");
        adminVO.setAdminPw("123");
        log.info("관리자 번호 : "+adminMapper.login(adminVO));
    }

}
