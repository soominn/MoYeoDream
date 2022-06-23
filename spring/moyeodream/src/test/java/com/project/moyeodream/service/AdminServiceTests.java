package com.project.moyeodream.service;

import com.project.moyeodream.domain.dao.AdminDAO;
import com.project.moyeodream.domain.vo.AdminVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class AdminServiceTests {
    @Autowired
    private AdminDAO adminDAO;

    @Test
    public void loginTest() {
        AdminVO adminVO = new AdminVO();
        adminVO.setAdminId("admin");
        adminVO.setAdminPw("123");
        log.info("관리자 번호 : " + adminDAO.login(adminVO));
    }
}
