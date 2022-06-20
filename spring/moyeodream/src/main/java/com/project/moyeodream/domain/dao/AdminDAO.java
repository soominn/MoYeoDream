package com.project.moyeodream.domain.dao;

import com.project.moyeodream.domain.vo.AdminVO;
import com.project.moyeodream.mapper.AdminMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDAO {

    private AdminMapper adminMapper;

    // 관리자 로그인
    public int Login(AdminVO adminVO){
        return adminMapper.Login(adminVO);
    }
}
