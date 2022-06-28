package com.project.moyeodream.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class StudyDTO {
    private Integer studyNumber;                  // 스터디 공고 고유번호(DB SEQUENCE 사용)
    private String studyCategory;                 // 스터디 카테고리
    private String studyProcess;                  // 스터디 진행 방식
    private String studyStart;                    // 스터디 시작 날짜
    private String studyPeriod;                   // 스터디 진행 기간
    private String studyPersonnel;                // 스터디 모집 인원
    private String studyCommunication;            // 스터디 연락 방법(카카오 오픈채팅, 구글 폼 등)
    private String studyTitle;                    // 스터디 제목
    private String studyContent;                  // 스터디 내용
    private String studyChief;                    // 스터디장 소개
    private Integer studyApprove;                 // 스터디 승인 여부(defalut : 0, 승인 시 1)
    private Integer studyViews;                   // 스터디 조회수
    private Integer studyCheck;                   // 스터디 체크여부
    private String studyRegisterDate;             // 스터디 작성날짜(DB SYSDATE 사용)
    private String studyUpdateDate;               // 스터디 수정날짜(DB SYSDATE 사용)
    private Integer studyMemberNumber;            // 스터디 멤버 넘버(FK)    -   스터디 작성자 정보 가져오기 위해
    private String memberNickname;                // 스터디 멤버의 닉네임
}
