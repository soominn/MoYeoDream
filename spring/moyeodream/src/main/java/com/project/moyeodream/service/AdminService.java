package com.project.moyeodream.service;


import com.project.moyeodream.domain.vo.AdminVO;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {

    // 관리자 로그인
    public int Login(AdminVO adminVO);
}
