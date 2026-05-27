# Spring Team Project: 모여드림 (MoYeoDream)

취준생·직장인을 위한 **스터디 그룹 매칭/운영 서비스**입니다.  
Spring Boot 기반으로 회원 인증, 스터디 기능, 화면 렌더링, REST API 연동을 구현했습니다.

---

## 1) 프로젝트 소개

**모여드림(MoYeoDream)**은 스터디를 찾거나 직접 개설해 운영할 수 있는 웹 서비스입니다.

- 사용자: 스터디 탐색/참여, 회원 인증, 로그인/로그아웃
- 운영 측면: 스터디 모집/관리 중심 기능
- 서비스 목표: 학습/취업 준비를 위한 지속 가능한 스터디 환경 제공

---

## 2) 주요 기능

- **회원 인증**
  - 카카오 소셜 로그인 기반 인증 처리
  - 카카오 로그인만으로 회원가입/로그인 플로우 구성
- **스터디 기능**
  - 스터디 조회/참여/운영(프로젝트 구조 기준)
- **사용자 경험**
  - Thymeleaf 기반 화면 구성
  - AJAX + REST API로 비동기 처리

---

## 3) 담당 역할

- 부팀장
- 서비스 기획 및 전반적인 프론트엔드 페이지 작업
- Presentation Tier 담당
- 스터디/회원가입/로그인/로그아웃 기능 개발
- REST API 기반 카카오 소셜 로그인 구현
- 카카오 로그인 전용 가입/인증 흐름 구현

---

## 4) 기술 스택

### Backend
- Java
- Spring Boot
- MyBatis
- Oracle

### Frontend
- Thymeleaf
- HTML / CSS / JavaScript
- jQuery
- AJAX

### External API
- Kakao Login REST API

---

## 5) 프로젝트 구조

```text
MoYeoDream/
├─ spring/moyeodream/   # Spring Boot 애플리케이션 소스
├─ views/               # 화면 템플릿/정적 리소스(구성 기준)
├─ README.md
└─ .gitignore
```

> 상세 패키지 구조(Controller/Service/Mapper/Domain)는 `spring/moyeodream` 하위에서 확인할 수 있습니다.

---

## 6) 실행 방법 (로컬)

### 1. 사전 준비
- JDK 11+ (권장)
- Oracle DB
- Gradle 또는 Maven 환경

### 2. 환경 설정
- DB 연결 정보 설정
- Kakao REST API 키/리다이렉트 URI 설정
- (필요 시) `application.yml` 또는 `application.properties`에 민감정보 분리

### 3. 실행
- IDE 또는 빌드 도구로 Spring Boot 애플리케이션 실행
- 기본 포트 접속 후 기능 테스트

---

## 7) 협업 및 개발 포인트

- 팀 프로젝트에서 역할 분담과 커뮤니케이션 규칙을 명확히 하여 충돌을 줄임
- REST API 기반 인증/비동기 처리 경험 축적
- 이전 프로젝트 대비 구조화/완성도 개선

---

## 8) 회고

짧은 기간 내 다양한 기술을 적용하며 RESTful 설계와 소셜 로그인 흐름을 실무형으로 경험했습니다.  
특히 팀 내 소통을 강화했을 때 병합 충돌이 줄고 개발 품질이 개선된 점이 가장 큰 성과였습니다.

---

## 9) DB 엔티티 관계도

모여드림 서비스에서 사용한 주요 도메인 ERD입니다.

- 이미지: ![DB 모여드림](https://user-images.githubusercontent.com/82988454/180593554-131ba54a-f507-4e07-91ec-134d73d2869c.JPG)

---

## 10) 참고

- 원본 저장소: https://github.com/soominn/MoYeoDream
