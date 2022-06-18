package com.project.moyeodream.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PostVO {
    private Integer postNumber;                   // 게시글 고유번호(DB SEQUENCE 사용)
    private String postCategory;                  // 게시글 카테고리
    private String postTitle;                     // 게시글 제목
    private String postContent;                   // 게시글 내용
    private Integer postViews;                    // 게시글 조회수
    private String postRegisterDate;              // 게시글 작성날짜(DB SYSDATE 사용)
    private String postUpdateDate;                // 게시글 수정날짜(DB SYSDATE 사용)
    private Integer postMemberNumber;             // 게시글 멤버 넘버(FK)  -   게시글 작성자 정보 가져오기 위해
}
