package com.project.moyeodream.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CommentVO {
    private Integer commentNumber;                   // 댓글 고유번호(DB SEQUENCE 사용)
    private String commentRegisterDate;              // 댓글 작성날짜(DB SYSDATE 사용)
    private String commentUpdateDate;                // 댓글 수정날짜(DB SYSDATE 사용)
    private String commentContent;                   // 댓글 내용
    private Integer commentMemberNumber;             // 댓글 멤버 넘버(FK)    -   댓글 작성자 정보 가져오기 위해
}
