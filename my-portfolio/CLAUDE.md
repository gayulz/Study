# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## 프로젝트 개요

유우리(gayul.kim)의 개인 포트폴리오 사이트입니다. AI Studio에서 생성한 디자인 템플릿을 기반으로 제작되었으며, Vercel에 배포될 예정입니다.

## 기술 스택

- **프레임워크**: React 19 + TypeScript + Vite
- **스타일링**: Tailwind CSS 4.1 (Vite 플러그인 방식)
- **애니메이션**: Motion (Framer Motion fork)
- **3D**: Spline (iframe 통합)
- **아이콘**: Lucide React
- **배포**: Vercel (예정)

## 주요 명령어

```bash
# 개발 서버 실행 (포트 3000, 모든 호스트 접근 허용)
npm run dev

# 프로덕션 빌드
npm run build

# 빌드 결과 미리보기
npm run preview

# 타입 체크 (린트)
npm run lint

# 빌드 결과물 제거
npm run clean
```

## 프로젝트 구조 및 아키텍처

### 컴포넌트 구성

단일 페이지 포트폴리오로, 각 섹션이 독립된 컴포넌트로 구성되어 있습니다:

```
src/
├── App.tsx              # 메인 앱 (모든 섹션 조합)
├── components/
│   ├── Header.tsx       # 네비게이션 헤더
│   ├── Hero.tsx         # 히어로 섹션 (Spline 3D 배경)
│   ├── About.tsx        # 소개 섹션
│   ├── Projects.tsx     # 프로젝트 섹션
│   ├── Experience.tsx   # 경력 섹션
│   ├── Education.tsx    # 학력 섹션
│   ├── Writing.tsx      # 글쓰기 섹션
│   ├── Contact.tsx      # 연락처 섹션
│   ├── SplineScene.tsx  # Spline 3D 장면 래퍼
│   └── ui/
│       └── Section.tsx  # 공통 섹션 레이아웃 컴포넌트
└── lib/
    └── utils.ts         # clsx + tailwind-merge 유틸리티
```

### 섹션 렌더링 순서

App.tsx에 정의된 섹션 순서:
1. Hero (풀스크린 3D 배경)
2. About
3. Projects
4. Experience
5. Education
6. Writing
7. Contact

### 스타일링 시스템

- **Tailwind CSS 4.1**: `@tailwindcss/vite` 플러그인 사용 (설정 파일 불필요)
- **커스텀 테마**: `src/index.css`의 `@theme` 블록에 정의
  - 폰트: `font-display` (Anton), `font-sans` (Inter)
  - 컬러: `hot-pink` (#FF007F), `hot-pink-hover` (#D6006A)
- **애니메이션**: Motion 라이브러리 사용 (Framer Motion fork)

### 환경변수

- `GEMINI_API_KEY`: Gemini API 키 (`.env.local`에 설정)
- Vite 설정에서 `process.env.GEMINI_API_KEY`로 주입됨

## 개발 시 주의사항

### 컨텐츠 수정

- **모든 샘플 컨텐츠를 유우리의 실제 정보로 교체해야 함**
- 각 컴포넌트 파일에서 하드코딩된 텍스트, 이미지, 링크를 수정
- Footer의 "VILLO"를 실제 이름으로 변경

### Vercel 배포 준비

- `npm run build` 실행하여 빌드 오류 확인
- 환경변수 `.env.local`은 Vercel 대시보드에서 설정 필요
- Vercel은 Vite 프로젝트를 자동 감지하여 빌드함

### Spline 통합

- `SplineScene.tsx`는 iframe으로 Spline 씬을 로드
- Spline URL은 하드코딩되어 있으므로 필요 시 변경

### 타입 안정성

- `npm run lint` 명령으로 타입 체크 (tsc --noEmit)
- 빌드 전 반드시 타입 오류 해결
