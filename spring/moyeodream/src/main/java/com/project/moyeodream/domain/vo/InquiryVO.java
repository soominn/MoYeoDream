package com.project.moyeodream.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class InquiryVO {
    private Integer inquiryNumber;                   // 문의 고유번호(DB SEQUENCE 사용)
    private String inquiryTitle;                     // 문의 제목
    private String inquiryContent;                   // 문의 내용
    private String inquiryAnswer;                    // 답변 내용
    private Integer inquiryViews;                    // 문의 조회수
    private String inquiryRegisterDate;              // 문의 작성날짜(DB SYSDATE 사용)
    private String inquiryUpdateDate;                // 문의 수정날짜(DB SYSDATE 사용)
    private Integer inquiryAnswerBool;               // 문의 답변 여부(defalut : 0, 답변 시 1)
    private Integer inquiryMemberNumber;             // 문의 멤버 넘버(FK)    -   문의 작성자 정보 가져오기 위해

}
