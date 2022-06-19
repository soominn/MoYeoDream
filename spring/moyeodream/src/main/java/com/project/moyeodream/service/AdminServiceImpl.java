package com.project.moyeodream.service;

import com.project.moyeodream.domain.vo.AdminVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Qualifier("admin")
public class AdminServiceImpl implements AdminService{

    @Override
    public int Login(AdminVO adminVO) {
        return 0;
    }
}
