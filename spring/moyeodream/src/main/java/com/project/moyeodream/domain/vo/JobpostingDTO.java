package com.project.moyeodream.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class JobpostingDTO {
    private Long jobpostingNumber;                   // 채용 공고 고유번호(DB SEQUENCE 사용)
    private String jobpostingCompanyName;               // 회사 이름
    private String jobpostingCompanyLogo;               // 회사 로고
    private String jobpostingApplicationStart;          // 접수 기간(시작)
    private String jobpostingApplicationEnd;            // 접수 기간(끝)
    private String jobpostingCareer;                    // 접수 채용 형태(신입, 경력 N년)
    private String jobpostingWorktype;                  // 접수 채용 형태(정규, 비정규, 인턴,)
    private String jobpostingEligibility;               // 지원 자격
    private String jobpostingArea;                      // 근무 지역
    private String jobpostingCompanyUrl;                // 회사 사이트(url)
    private String jobpostingTitle;                     // 채용 공고 제목
    private String jobpostingContent;                   // 채용 공고 내용
    private String jobpostingRegisterDate;              // 채용 공고 작성날짜(DB SYSDATE 사용)
    private Integer jobpostingViews;                    // 채용 공고 조회수
    private Integer jobpostingApprove;                  // 채용 공고 승인 여부(defalut : 0, 승인 시 1)
    private Integer jobpostingDelete;                   // 채용 공고 삭제 여부(defalut : 0, 삭제 시 1)
    private Integer jobpostingMemberNumber;             // 채용 공고 멤버 넘버(FK)    -   채용 공고 작성자 정보 가져오기 위해
    private String memberNickname;                     // 채용자 이름
}
