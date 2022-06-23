package com.project.moyeodream.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class AdminVO {
    private Integer adminNumber;                // 관리자 고유번호(DB SEQUENCE 사용)
    private String adminId;                    // 관리자 아이디
    private String adminPw;                    // 관리자 비밀번호
}
