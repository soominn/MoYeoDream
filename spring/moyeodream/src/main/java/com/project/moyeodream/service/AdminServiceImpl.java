package com.project.moyeodream.service;

import com.project.moyeodream.domain.dao.AdminDAO;
import com.project.moyeodream.domain.vo.AdminVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Qualifier("admin")
public class AdminServiceImpl implements AdminService{
    private final AdminDAO adminDAO;

    @Override
    public int login(AdminVO adminVO) {
        return adminDAO.login(adminVO);
    }

    @Override
    public String id(String id) {
        return adminDAO.id(id);
    }
}
