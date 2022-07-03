package com.project.moyeodream.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PostCommentVO {
    private Integer postCommentNumber;                   // 댓글 고유번호(DB SEQUENCE 사용)
    private String postCommentContent;                   // 댓글 내용
    private String postCommentRegisterDate;              // 댓글 작성날짜(DB SYSDATE 사용)
    private String postCommentUpdateDate;                // 댓글 수정날짜(DB SYSDATE 사용)
    private Integer postCommentMemberNumber;             // 댓글 멤버 넘버(FK)    -   댓글 작성자 정보 가져오기 위해
    private Integer postCommentPostNumber;               // 댓글 멤버 넘버(FK)    -   댓글의 게시글 정보 가져오기 위해
    private String postCommentNickname;                 // 작성자 닉네임
    private String memberProfile;                 // 작성자 프로필 이미지
}
