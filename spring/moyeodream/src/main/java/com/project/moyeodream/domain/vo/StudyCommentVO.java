package com.project.moyeodream.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class StudyCommentVO {
    private Integer studyCommentNumber;                   // 댓글 고유번호(DB SEQUENCE 사용)
    private String studyCommentContent;                   // 댓글 내용
    private String studyCommentRegisterDate;              // 댓글 작성날짜(DB SYSDATE 사용)
    private String studyCommentUpdateDate;                // 댓글 수정날짜(DB SYSDATE 사용)
    private Integer studyCommentMemberNumber;             // 댓글 멤버 넘버(FK)    -   댓글 작성자 정보 가져오기 위해
    private Integer studyCommentStudyNumber;              // 댓글 멤버 넘버(FK)    -   댓글의 게시글 정보 가져오기 위해

}
