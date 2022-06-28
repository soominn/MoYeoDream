package com.project.moyeodream.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class InquiryCommentVO {
    private Integer inquiryCommentNumber;                   // 댓글 고유번호(DB SEQUENCE 사용)
    private String inquiryCommentContent;                   // 댓글 내용
    private String inquiryCommentRegisterDate;              // 댓글 작성날짜(DB SYSDATE 사용)
    private String inquiryCommentUpdateDate;                // 댓글 수정날짜(DB SYSDATE 사용)
    private Integer inquiryCommentMemberNumber;             // 댓글 멤버 넘버(FK)    -   댓글 작성자 정보 가져오기 위해
    private Integer inquiryNumber;                      // 댓글 멤버 넘버(FK)    -   댓글의 게시글 정보 가져오기 위해
    private Integer commentTotal;                         // 댓글 총개수
}
