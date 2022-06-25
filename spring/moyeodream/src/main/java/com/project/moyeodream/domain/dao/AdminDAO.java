package com.project.moyeodream.domain.dao;

import com.project.moyeodream.domain.vo.AdminVO;
import com.project.moyeodream.mapper.AdminMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class AdminDAO {
    private final AdminMapper adminMapper;
    // 관리자 로그인
    public int login(AdminVO adminVO){
        if(adminMapper.login(adminVO)==null){
            return 0;
        }
        return adminMapper.login(adminVO);
    }
    // 아이디 조회
    public String id(String id){
        return adminMapper.id(id);
    }
}
