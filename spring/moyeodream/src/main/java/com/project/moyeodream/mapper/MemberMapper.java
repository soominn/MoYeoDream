package com.project.moyeodream.mapper;

import com.project.moyeodream.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper //스프링 마이바티스에서 xml파일과 연결될 Mapper 인터페이스임을 알려준다.
public interface MemberMapper {
    // 회원 가입
    public void insert(MemberVO memberVO);
    // 내 정보 보기
    public MemberVO select(int memberNumber);
    // 내 정보 수정
    public int update(MemberVO memberVO);
    // 회원 탈퇴
    public int delete(int memberNumber);
}
