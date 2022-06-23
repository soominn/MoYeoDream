package com.project.moyeodream.mapper;

import com.project.moyeodream.domain.vo.AdminVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper //스프링 마이바티스에서 xml파일과 연결될 Mapper 인터페이스임을 알려준다.
public interface AdminMapper {
    // 관리자 로그인
    public int login(AdminVO adminVO);
}
